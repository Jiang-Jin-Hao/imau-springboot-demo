package com.example.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

//@Component // 被放进Bean容器
public class IndexController {

    @RequestMapping
    public String index(){

        System.out.println("index");

        return "index.html";
    }

}
