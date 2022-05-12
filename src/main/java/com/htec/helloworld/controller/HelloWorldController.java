package com.htec.helloworld.controller;

import com.htec.helloworld.service.HelloWorldService;
import com.htec.helloworld.service.HelloWorldServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/hello")
    public String sayHello() {
        return helloWorldService.getMessage();
    }
}
