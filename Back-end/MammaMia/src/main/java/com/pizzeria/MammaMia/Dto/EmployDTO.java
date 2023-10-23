package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Permission;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import lombok.Data;

@Data
public class EmployDTO {
    private Integer id;
    private RegisterUser registerUser;
    private String cpf;
    private String name;
    private String phone;
    private Permission permission;
    private int salary;
    public EmployDTO(){}
    public EmployDTO(Integer id, RegisterUser registerUser, String cpf, String name, String phone, Permission permission, int salary) {
        this.id = id;
        this.registerUser = registerUser;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
        this.permission = permission;
        this.salary = salary;
    }
    public EmployDTO employDTO() {
        return new EmployDTO(id, registerUser, cpf, name, phone, permission, salary);
    }
}
