package com.onyetech.onyetech.service;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.enums.UserRole;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

@Service
public class LoginService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    @Autowired
    public LoginService(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
    }


    public ResponseEntity<?> loginUser(@RequestBody LoginRequest request, HttpServletResponse response) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

            User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + request.getEmail()));

            UserRole roles = user.getUserRole().getName();

            String jwt = utils.generateJwtToken(authentication);
            System.out.println(jwt);
            System.out.println(authentication);
            if(user.getEnabled()) {
                response.addHeader("Authorization", "Bearer " + jwt);
                return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), user.getId(), roles));
            }else {
                return ResponseEntity.badRequest().body("Email has not been verified");
            }

        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password!");
        }
    }
}
