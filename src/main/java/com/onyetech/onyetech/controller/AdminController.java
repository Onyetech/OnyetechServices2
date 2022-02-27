package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.response.GetUsersResponse;
import com.onyetech.onyetech.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/admin")
public class AdminController {

    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public AdminController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


//    @GetMapping("/users")
//    public ResponseEntity<?> getUsers(@RequestParam(name = "page", defaultValue = "0") int page,
//                                               @RequestParam(name = "size", defaultValue = "2") int size){
//
//        GetUsersResponse users = userService.getAllUsers(page, size, "name");
//        return ResponseEntity.ok(users);
//    }


}
