package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "register_user")
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
    @Column(name = "last_login")
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
    public RegisterUserDTO toDTO() {
        return new RegisterUserDTO(userId, name, email, password, salt, isActive, lastLogin);
    }
}
