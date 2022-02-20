package com.onyetech.onyetech.service;

import com.onyetech.onyetech.entity.User;

public interface UserRepository {
    User authUserLogin(String email, String password);
}
