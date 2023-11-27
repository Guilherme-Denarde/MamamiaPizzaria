package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.ClientDTO;
import com.pizzeria.MammaMia.security.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @Getter @Setter
    @JoinColumn(name = "user_id")
    private User registerUser;
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
    public Client(Integer id, User registerUser, Address address, String cpf, String name, String phone) {
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
