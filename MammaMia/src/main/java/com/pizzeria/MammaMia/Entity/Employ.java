package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "employ")
public class Employ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL )
    @JoinColumn(name = "user_id")
    private RegisterUser registerUser;
    private String cpf;
    private String name;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Permission permission;
    private int salary;

    public Employ(Long id, RegisterUser registerUser, String cpf, String name, String phone, Permission permission, int salary) {
        this.id = id;
        this.registerUser = registerUser;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.permission = permission;
        this.salary = salary;
    }

    public EmployDTO toDTO() {
        return new EmployDTO(id, registerUser, cpf, name, phone, permission, salary);
    }
}
