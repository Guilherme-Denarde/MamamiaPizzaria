package com.pizzeria.MammaMia.Dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RegisterUserDTO {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private String salt;
    private Boolean isActive;
    private Timestamp lastLogin;
    public RegisterUserDTO(){
    }
    public RegisterUserDTO(Integer userId, String name, String email, String password, String salt, Boolean isActive, Timestamp lastLogin) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.salt = salt;
        this.isActive = isActive;
        this.lastLogin = lastLogin;
    }
}
