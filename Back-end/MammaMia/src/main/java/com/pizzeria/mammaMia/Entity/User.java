package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "\"user\"")
public class User extends AbstractEntity {
    private String name;
    private String email;
    private String password;
    private String phone;
    private String profile_picture;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date date_of_birth;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @OneToMany(mappedBy = "user")
    private Set<Address> addresses;
    @OneToMany(mappedBy = "user")
    private Set<Order> orders;
    @OneToMany(mappedBy = "user")
    private Set<Card> cards;

    @OneToMany(mappedBy = "user")
    private Set<Review> reviews;

}