package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping(path = "admin")
public class AdminController {

    private final User user;

    Map<String, User> users;

    @GetMapping(path="/user/{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<User> getUser(@PathVariable String userId, @RequestParam(value ="page", defaultValue = "1") int page,
                                        @RequestParam(value ="limit", defaultValue = "50") int limit,
                                        @RequestParam(value ="sort", defaultValue = "desc", required = false) String sort){
        if (users.containsKey(userId)){
            return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


    }
}
