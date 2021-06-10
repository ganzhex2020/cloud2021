package com.jony.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import static javax.websocket.CloseReason.CloseCodes.GOING_AWAY;
import static javax.websocket.CloseReason.CloseCodes.NORMAL_CLOSURE;

@ServerEndpoint(value = "/websocket") //接受websocket请求路径
@Component  //注册到spring容器中
@Slf4j
public class MyWebSocket {

    //保存所有在线socket连接
    private static Map<String,Session> clients = new ConcurrentSkipListMap<>();

    //记录当前在线数目
    private static int count=0;

    //当前连接（每个websocket连入都会创建一个MyWebSocket实例
 //   private Session session;

   // private Logger log = LoggerFactory.getLogger(this.getClass());
    //处理连接建立
    @OnOpen
    public void onOpen(Session session){
      //  this.session=session;
      //  session.setMaxIdleTimeout(20000);
        clients.put(session.getId(),session);
        addCount();
        log.info("新的连接加入：sessionId:"+session.getId()+" session:"+session);
    }

    //接受消息
    @OnMessage
    public void onMessage(String message,Session session){
        log.info("收到客户端{}消息：{}",session.getId(),message);
        try{
            sendMessage("收到消息："+message,session);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    //处理错误
    @OnError
    public void onError(Throwable error,Session session){
        log.info("发生错误{},{}",session.getId(),error.getMessage());
    }

    //处理连接关闭
    @OnClose
    public void onClose(Session session){
        clients.remove(session.getId());
        reduceCount();
        log.info("连接关闭:{}",session.getId());
    }

    //群发消息

    //发送消息
    public static void sendMessage(String message,Session session) throws IOException {
        session.getBasicRemote().sendText(message);
    }

    //广播消息
    public static void broadcast(){
        clients.forEach((k,v)->{
            try{
                log.info("k:"+k+" v:"+v.getId());
                sendMessage("这是一条测试广播",v);
            }catch (Exception e){
            }
        });
    }

    public static void setExpired(){
        clients.forEach((k,v)->{
            try {
                v.close(new CloseReason(GOING_AWAY,"服务端主动关闭"));
            }catch (Exception e){

            }
        });
    }

    //获取在线连接数目
    public static int getCount(){
        return count;
    }

    //操作count，使用synchronized确保线程安全
    public static synchronized void addCount(){
        MyWebSocket.count++;
    }

    public static synchronized void reduceCount(){
        MyWebSocket.count--;
    }

}
