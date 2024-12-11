package com.example.movierecommendation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityDemoController {

    @GetMapping("/admin/greet")
    public String greetAdmin(@RequestParam String user){
        return "Hello "+ user;
    }

    @GetMapping("/user/greet")
    public String greetUser(@RequestParam String user){
        return "Hello "+ user;
    }

}
