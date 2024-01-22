package com.example.service;

import com.example.enums.Authorities;
import com.example.exception.InvalidCredentials;
import com.example.exception.UnauthorizedUser;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizationService {
    private final UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(String name, String password) {
        if (isEmpty(name) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(name, password);

        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + name);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
