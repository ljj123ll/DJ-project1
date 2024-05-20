package com.example.djproject1.controller;

import com.example.djproject1.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsController {

    @GetMapping("/getTest1")
    public String getTest1(){
        return "Get请求";
    }

    //localhost:8086/getTest2?nickname=罗俊杰&phone=123456
    @GetMapping("/getTest2")
    public String getTest2(String nickname,String phone){
        System.out.println("nickname "+nickname);
        System.out.println("phone "+phone);
        return "Get请求";
    }

    //localhost:8086/getTest2?nickname=罗俊杰
    @GetMapping("/getTest3")
    public String getTest3(@RequestParam(value = "nickname",required = false) String name){
        System.out.println("nickname "+name);

        return "Get请求";
    }

    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String postTest1(){
        return "POST请求";
    }

    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public String postTest2(String username,String password){
        System.out.println("username "+username);
        System.out.println("password "+password);
        return "POST请求";
    }

    @RequestMapping(value = "/postTest3",method = RequestMethod.POST)
    public String postTest3(User user){
        System.out.println(user);

        return "POST请求";
    }

    @RequestMapping(value = "/postTest4",method = RequestMethod.POST)
    public String postTest4(@RequestBody User user){
        System.out.println(user);

        return "POST请求";
    }

    @GetMapping("/test/*")
    public String test(){
        return "通配符请求";
    }




}
