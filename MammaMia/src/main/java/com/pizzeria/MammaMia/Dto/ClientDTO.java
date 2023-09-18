package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private RegisterUser registerUser;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String cpf;
    private String name;
    private String phone;
    public ClientDTO() {
    }
    public ClientDTO(Long id, RegisterUser registerUser, Address address, String cpf, String name, String phone) {
        this.id = id;
        this.registerUser = registerUser;
        this.address = address;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
}
