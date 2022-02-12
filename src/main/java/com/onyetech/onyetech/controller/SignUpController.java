package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.request.RegistrationRequest;
import com.onyetech.onyetech.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(path = "user")
public class SignUpController {

    private RegistrationService registrationService;


    @PostMapping("/registration")
    public String registerUser(@RequestBody RegistrationRequest request){

    return registrationService.register(request);

}

}
