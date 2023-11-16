package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.RegisterUser;
import lombok.Data;

import java.io.Serial;

@Data
public class AddressDTO {
    private Integer id;
    private String streetName;
    private int streetNum;
    private String addressReference;
    private String city;
    private String state;
    private String postalCode;

    public AddressDTO(){}

    public AddressDTO(Integer id, String streetName, int streetNum, String addressReference, String city, String state, String postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.addressReference = addressReference;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public AddressDTO(Serial id, RegisterUser registerUser, String cpf, String name, String phone, Permission permission, int salary) {
    }
}
