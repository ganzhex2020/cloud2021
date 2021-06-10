package com.jony.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/broadcast")
    public void broadcast(){
        MyWebSocket.broadcast();
    }

    @GetMapping("/expired")
    public void expired(){
        MyWebSocket.setExpired();
    }

    @GetMapping("/count")
    public Object getCount(){
        return "有多少人在线:"+MyWebSocket.getCount();
    }
}
