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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private RegisterUser registerUser;
    private String cpf;
    private String name;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Permission permission;
    private int salary;

    public Employ(Long id, RegisterUser registerUser, String cpf, String name, String phone, Permission permission, int salary) {
    }

    public EmployDTO toDTO() {
        return new EmployDTO(id, registerUser, cpf, name, phone, permission, salary);
    }
}
