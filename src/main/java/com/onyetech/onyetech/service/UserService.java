package com.onyetech.onyetech.service;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.request.LoginRequest;
import com.onyetech.onyetech.security.config.PasswordHashing;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {


    private final static String USER_NOT_FOUND_MSG = "User with the email %s not found";
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void enableUser(String email) {
        userRepository.enableUser(email);
    }

    public Object authUserLogin(@RequestBody LoginRequest request, User users) {

        var user = userRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
        PasswordHashing.decryptPassword(request.getPassword());

        if (user.isEmpty()) {
            return "Mistake somewhere";

        } else {
            return request.getEmail() + ", you are successfully logged in! You can continue.";

        }
    }
}
