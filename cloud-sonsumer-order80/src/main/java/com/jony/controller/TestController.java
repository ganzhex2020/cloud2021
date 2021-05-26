package com.jony.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/consumer/test")
    public Object gettest(){
        return "it it order80";
    }
}
