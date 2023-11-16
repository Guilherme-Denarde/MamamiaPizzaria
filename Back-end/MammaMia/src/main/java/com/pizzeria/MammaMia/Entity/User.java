package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "\"user\"")
public class User extends AbstractEntity {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String profile_picture;
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;
}