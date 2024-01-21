package com.example.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
    @NotEmpty(message = "Name should not be empty")
    @Size(min =2, max = 30, message = " 2 < Name < 30" )
    private String name;
    @Min(value = 0, message = "Age should be > 0")
    private int password;

    public User() {
    }

    public User(String name, int password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
