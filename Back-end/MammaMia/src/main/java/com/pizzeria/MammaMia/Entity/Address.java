package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.math.BigInteger;

@Entity
@Data
@Table(name = "address")
public class Address extends AbstractEntity {

    @Column(name = "streetname")
    private String streetName;

    @Column(name = "streetnum")
    private int streetNum;

    @Column(name = "addressreference")
    private String addressReference;

    private String city;

    private String state;

    private String postalCode;

    public Address(){
    }
    public Address(Long id, String streetName, int streetNum, String addressReference, String city, String state, String postalCode) {
        this.setId(id);
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.addressReference = addressReference;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }



    public static Address fromDTO(AddressDTO addressDto) {
        Long id = addressDto.getId() != null ? addressDto.getId().longValue() : null;
        return new Address(id, addressDto.getStreetName(), addressDto.getStreetNum(),
                addressDto.getAddressReference(), addressDto.getCity(),
                addressDto.getState(), addressDto.getPostalCode());
    }

    public AddressDTO toDTO() {
        return new AddressDTO(getId(), streetName, streetNum, addressReference, city, state, postalCode);
    }

}
