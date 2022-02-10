package com.onyetech.onyetech.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class SignUpController {

    @GetMapping("/register")
    public String welcome(){
        return "Welcome to our website";
    }

}
