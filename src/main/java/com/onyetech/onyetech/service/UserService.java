package com.onyetech.onyetech.service;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.request.LoginRequest;
import com.onyetech.onyetech.security.config.PasswordHashing;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;


@Service
//@AllArgsConstructor
public class UserService implements UserDetailsService {

    User user = new User();

    private final static String USER_NOT_FOUND_MSG = "User with the email %s not found";
    private final UserRepository userRepository;
    private final PasswordHashing passwordHashing;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordHashing passwordHashing, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.passwordHashing = passwordHashing;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).
                orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public void enableUser(String email) {
        userRepository.enableUser(email);
    }

    public Object authUserLogin(@RequestBody LoginRequest request, User users) {
        System.out.println(request);

//        var user = userRepository.findByEmailAndPassword(users.getEmail(), users.getPassword());
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        PasswordHashing.decryptPassword(request.getPassword());
        System.out.println("am here");
        if (!bCryptPasswordEncoder.matches(request.getPassword(),user.getPassword())) {
            return "Mistake somewhere";

        } else {
            return request.getEmail() + ", you are successfully logged in! You can continue.";

        }
    }

    public void deleteUser(Long userId){
        userRepository.delete(user);
    }
}
