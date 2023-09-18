package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.ClientDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @Getter @Setter
    @JoinColumn(name = "user_id")
    private RegisterUser registerUser;
    @ManyToOne
    @Getter @Setter
    @JoinColumn(name = "address_id")
    private Address address;
    @Getter @Setter
    private String cpf;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String phone;
    public Client() {
    }
    public Client(Long id, RegisterUser registerUser, Address address, String cpf, String name, String phone) {
        this.id = id;
        this.registerUser = registerUser;
        this.address = address;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
    public ClientDTO toDTO() {
        return new ClientDTO(id, registerUser, address, cpf, name, phone);
    }
}
