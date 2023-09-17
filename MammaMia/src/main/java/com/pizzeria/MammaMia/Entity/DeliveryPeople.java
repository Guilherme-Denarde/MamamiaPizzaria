package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_people")
public class DeliveryPeople {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long did;
    @ManyToOne
    @JoinColumn(name = "employ_id")
    private Employ employ;
    private String cpf;
    private String name;
    private String phone;
    public DeliveryPeople(){}
    public DeliveryPeople(Long id, Employ employ, String cpf, String name, String phone) {
        this.id = id;
        this.employ = employ;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }

    public AddressDTO toDTO() {
        return new AddressDTO(id, employ, cpf, name, phone);
    }

}
