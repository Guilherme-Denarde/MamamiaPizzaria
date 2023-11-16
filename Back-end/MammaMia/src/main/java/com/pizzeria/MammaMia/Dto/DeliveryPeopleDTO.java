package com.pizzeria.MammaMia.Dto;

import lombok.Data;

@Data
public class DeliveryPeopleDTO {
    private Integer id;
    private String cpf;
    private String name;
    private String phone;

    public DeliveryPeopleDTO(){}

    public DeliveryPeopleDTO(Integer id, String cpf, String name, String phone) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
}
