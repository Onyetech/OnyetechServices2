package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.request.LoginRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class LoginController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        Optional<User> user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword());
        if (user.isPresent() && user.get().getPassword().equals(request.getPassword())) {
            return user.get().getFirstName()+ ", you are successfully logged in! You can continue.";
        }
        else throw new RuntimeException("user does not exist");

    }
}
