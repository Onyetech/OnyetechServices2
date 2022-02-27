package com.onyetech.onyetech.security.config;

public class SecurityConstants {
    public static final String [] PUBLIC_URI = {

            "/user/**",
            "/admin/**",
            //swagger
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/swagger-ui.html**",
            "/webjars/**",
            "/v3/api-docs/**",
            "/swagger-ui/**",
            "/swagger-ui/login/",
            "/swagger-ui/api/login/",
            "/swagger-ui/#/**",
            //swagger ends

    };
}
