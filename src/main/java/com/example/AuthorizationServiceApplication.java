package com.example;

import com.example.controllers.AuthorizationController;
import com.example.repository.UserRepository;
import com.example.service.AuthorizationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthorizationServiceApplication {

    public static void main(String[] args) {

		SpringApplication.run(AuthorizationServiceApplication.class, args);
    }
    @Bean
    public AuthorizationService authorizationService(UserRepository userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public AuthorizationController authorizationController(AuthorizationService authorizationService) {
        return new AuthorizationController(authorizationService);
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository();
    }
}
