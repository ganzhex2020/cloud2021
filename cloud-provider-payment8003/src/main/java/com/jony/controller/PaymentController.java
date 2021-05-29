package com.jony.controller;


import com.jony.entity.CommonResult;
import com.jony.entity.Payment;
import com.jony.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*** 插入结果:"+result);


        if (result>0){
            return new CommonResult(200,"插入成功,serverPort:"+serverPort);
        }else {
            return new CommonResult(444,"插入失败");
        }
    }

    @GetMapping("/payment/getPayment/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*** 查询结果:"+payment);

        if (payment!=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录:id "+id);
        }
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout()
    {
        // 业务逻辑处理正确，但是需要耗费3秒钟
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

}
