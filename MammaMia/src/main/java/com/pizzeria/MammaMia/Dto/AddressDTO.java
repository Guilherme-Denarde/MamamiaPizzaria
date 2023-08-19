package com.pizzeria.MammaMia.Dto;

import lombok.Data;

@Data
public class AddressDTO {
    private Long id;
    private String streetName;
    private int streetNum;
    private String addressReference;
    private String city;
    private String state;
    private String postalCode;

    public AddressDTO(){}

    public AddressDTO(Long id, String streetName, int streetNum, String addressReference, String city, String state, String postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.addressReference = addressReference;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

}
