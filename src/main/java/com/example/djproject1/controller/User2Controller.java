package com.example.djproject1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User2Controller {

    @GetMapping("/user2")
    public String query(){

        return "查询用户";
    }
}
