package com.onyetech.onyetech.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
public class MessageResponse {
    private String response;
    private final String token;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    }

