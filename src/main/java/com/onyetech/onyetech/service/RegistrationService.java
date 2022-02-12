package com.onyetech.onyetech.service;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.enums.UserRole;
import com.onyetech.onyetech.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final UserService userService;

    public String register(RegistrationRequest request) {
        return userService.signUpUser(
                new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword(),
                UserRole.USER
                )
        );
    }
}
