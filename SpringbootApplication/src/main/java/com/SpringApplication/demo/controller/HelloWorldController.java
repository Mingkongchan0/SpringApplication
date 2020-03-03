package com.SpringApplication.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RefreshScope
public class HelloWorldController {
    @Value("${spring.profiles.active}")
    private String active;
    @RequestMapping("/sayHello")
    @ResponseBody
    String sayHello()
    {
        return("H 3 L L 0  " + active);
    }

}