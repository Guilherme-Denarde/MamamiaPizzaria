package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.Roles;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private Roles roleName;
    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
