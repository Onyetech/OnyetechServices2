package com.onyetech.onyetech.security.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder2 {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "1234";
        String rawPassword2 = "1234";
        String encodePassword = encoder.encode(rawPassword);
        String encodePassword2 = encoder.encode(rawPassword2);


        System.out.println(encodePassword);

        System.out.println(encodePassword2);
    }

}
