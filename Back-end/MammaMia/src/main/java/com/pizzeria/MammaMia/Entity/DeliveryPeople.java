package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.DeliveryPeopleDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "delivery_people")
public class DeliveryPeople {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String name;
    private String phone;
    public DeliveryPeople(Integer id, String cpf, String name, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
    public DeliveryPeopleDTO toDTO() {
        return new DeliveryPeopleDTO(id, cpf, name, phone);
    }
}
