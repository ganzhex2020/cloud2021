package com.jony;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication/*(exclude= {DataSourceAutoConfiguration.class})*/
@EnableEurekaClient
@EnableDiscoveryClient//添加该注解
public class PaymentMain8002 {

    public static void main(String[] args){
        SpringApplication.run(PaymentMain8002.class,args);
    }
}
