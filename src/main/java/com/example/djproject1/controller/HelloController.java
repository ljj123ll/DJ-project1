package com.example.djproject1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(String nickname, String phone){
        System.out.println(phone);
        System.out.println("你好世界");
        return "Love the 11111222223333344445555566777" +nickname;
    }

}
