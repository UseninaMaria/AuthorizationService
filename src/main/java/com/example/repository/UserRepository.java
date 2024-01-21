package com.example.repository;

import com.example.enums.Authorities;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        if (user.equals("admin") && password.equals("132465798")) {
            return List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        }
        if (user.equals("user") && password.equals("1111111111")) {
            return List.of(Authorities.READ, Authorities.WRITE);
        }
        if (user.equals("unregistered") && password.equals("000000000")) {
            return List.of(Authorities.READ);
        } else {
            return null;
        }
    }
}