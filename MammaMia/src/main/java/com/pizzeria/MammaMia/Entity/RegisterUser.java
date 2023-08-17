package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.security.Timestamp;

@Entity
public class RegisterUser {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String salt;
    @Getter @Setter
    private Boolean isActive;
    @Getter @Setter
    private Timestamp lastLogin;
    public RegisterUser(){
    }
    public RegisterUser(Long userId, String name, String email, String password, String salt, Boolean isActive, Timestamp lastLogin) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isActive = isActive;
        this.lastLogin = lastLogin;
    }
}
