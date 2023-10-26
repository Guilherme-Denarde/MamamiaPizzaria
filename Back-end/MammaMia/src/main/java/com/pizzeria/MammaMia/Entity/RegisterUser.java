package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.RegisterUserDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "register_user")
public class RegisterUser {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Getter @Setter
    @Column(unique = true)
    private String name;

    @Getter @Setter
    @Column(unique = true)
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

    public RegisterUser() {}

    public RegisterUser(Integer userId, String name, String email, String password, String salt, Boolean isActive, Timestamp lastLogin) {
        this.userId = userId;
        this.name = name;
        setEmail(email);
        this.password = password;
        this.salt = salt;
        this.isActive = isActive;
        this.lastLogin = lastLogin;
    }

    public void setEmail(String email) {
        if (isEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email must be a valid address");
        }
    }

    private boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public RegisterUserDTO toDTO() {
        return new RegisterUserDTO(userId, name, email, password, salt, isActive, lastLogin);
    }
}
