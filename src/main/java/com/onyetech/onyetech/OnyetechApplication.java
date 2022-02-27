package com.onyetech.onyetech;

import com.onyetech.onyetech.repository.UserRepository;
import com.onyetech.onyetech.token.ConfirmationTokenRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableJpaRepositories(basePackageClasses = {UserRepository.class, ConfirmationTokenRepository.class})
public class OnyetechApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnyetechApplication.class, args);
    }

}
