package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Employ;
import lombok.Data;

@Data
public class DeliveryPeopleDTO {
    private Integer id;
    private Employ employ;
    private String cpf;
    private String name;
    private String phone;

    public DeliveryPeopleDTO(){}

    public DeliveryPeopleDTO(Integer id, Employ employ, String cpf, String name, String phone) {
        this.id = id;
        this.employ = employ;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
}
