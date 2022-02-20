package com.onyetech.onyetech.security.config;


import org.springframework.context.annotation.Configuration;

import java.util.Base64;

@Configuration
public class PasswordHashing {
        public static String encryptPassword(String password) {
            return Base64.getEncoder().encodeToString(password.getBytes());
        }

        public static void decryptPassword(String encryptedString) {
            Base64.getMimeDecoder().decode(encryptedString);
        }
    }




