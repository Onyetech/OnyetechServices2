package com.onyetech.onyetech.controller;

import com.onyetech.onyetech.entity.User;
import com.onyetech.onyetech.enums.UserRole;
import com.onyetech.onyetech.request.LoginRequest;
import com.onyetech.onyetech.request.RegistrationRequest;
import com.onyetech.onyetech.request.UpdateUserDetailsRequest;
import com.onyetech.onyetech.service.RegistrationService;
import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.service.UserService;
import com.onyetech.onyetech.token.ConfirmationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;


@RestController
//@AllArgsConstructor
@RequestMapping(path = "/user")
public class UserController {

    Map<String, User> users;
//    User deleteUser = new User();

    private final RegistrationService registrationService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ConfirmationTokenRepository confirmationTokenRepository;
    private User user;

    @Autowired
    public UserController(RegistrationService registrationService, UserService userService, UserRepository userRepository, ConfirmationTokenRepository confirmationTokenRepository) {
        this.registrationService = registrationService;
        this.userService = userService;
        this.userRepository = userRepository;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @PostMapping("/registration")
    public String registerUser(@RequestBody RegistrationRequest request){

        return registrationService.register(request);
    }

    @GetMapping(path = "/sign-up/confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }


    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest request, User users) {

//        System.out.println(request.getPassword());
//        System.out.println(PasswordHashing.encryptPassword(request.getPassword()));
        return (String) userService.authUserLogin(request, users);
    }

    @PutMapping(path="/update-details/{userId}")
    public User updateUser(@PathVariable Long userId, @Valid @RequestBody UpdateUserDetailsRequest updatedUserDetail){
//        User user = userRepository.findByEmail(updatedUserDetail.getEmail())
//                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        User storedUserDetails = userRepository.findById(userId)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));

        storedUserDetails.setFirstName(updatedUserDetail.getFirstName());
        storedUserDetails.setLastName(updatedUserDetail.getLastName());
        storedUserDetails.setEmail(updatedUserDetail.getEmail());
        storedUserDetails.setPassword(updatedUserDetail.getPassword());
        storedUserDetails.setUserRole(UserRole.USER);
//        users.put(userId, storedUserDetails);
        userRepository.save(storedUserDetails);
        return storedUserDetails;
    }

    @DeleteMapping(path="/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){

//        userService.deleteUser(userId);
        confirmationTokenRepository.deleteAllByUserUserId(userId);
        userRepository.deleteById(userId);
        return "User successfully deleted!";
    }
}
