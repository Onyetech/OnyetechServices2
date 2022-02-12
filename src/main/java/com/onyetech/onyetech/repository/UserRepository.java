package com.onyetech.onyetech.repository;

import com.onyetech.onyetech.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository {
    Optional<User> findByEmail(String email);

}
