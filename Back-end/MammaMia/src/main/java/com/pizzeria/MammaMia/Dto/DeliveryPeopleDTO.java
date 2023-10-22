package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Employ;
import lombok.Data;

@Data
public class DeliveryPeopleDTO {
    private Long id;
    private Employ employ;
    private String cpf;
    private String name;
    private String phone;

    public DeliveryPeopleDTO(){}

    public DeliveryPeopleDTO(Long id, Employ employ, String cpf, String name, String phone) {
        this.id = id;
        this.employ = employ;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
}
