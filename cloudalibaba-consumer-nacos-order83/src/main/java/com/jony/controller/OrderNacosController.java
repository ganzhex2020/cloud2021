package com.jony.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@RestController
@Slf4j
public class OrderNacosController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${service-url.nacos-user-service}")
    private String serverURL; //= "http://nacos-payment-provider";



    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id)
    {
        log.info("testxx:xas");
        List<ServiceInstance> list = this.discoveryClient.getInstances("nacos-payment-provider");
        log.info(""+list);

        return restTemplate.getForObject("http://nacos-payment-provider"+"/payment/nacos/"+id,String.class);
    }

}
