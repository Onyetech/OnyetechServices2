package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.request.LoginRequest;
import com.onyetech.onyetech.security.config.PasswordHashing;
import com.onyetech.onyetech.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class LoginController {


    private final User user;
    private final UserService userService;

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request, User users) {

            System.out.println(request.getPassword());
            System.out.println(PasswordHashing.encryptPassword(request.getPassword()));
            return (String) userService.authUserLogin(request, users);

        }

}



