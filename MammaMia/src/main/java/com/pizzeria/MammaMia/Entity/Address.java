package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.math.BigInteger;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter @Setter
    @Column(name = "streetname")
    private String streetName;
    @Getter @Setter
    @Column(name = "streetnum")
    private int streetNum;
    @Getter @Setter
    @Column(name = "addressreference")
    private String addressReference;
    @Getter @Setter
    private String city;
    @Getter @Setter
    private String state;
    @Getter @Setter
    private String postalCode;
    public Address(){
    }
    public Address(Long id, String streetName, int streetNum, String addressReference, String city, String state, String postalCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNum = streetNum;
        this.addressReference = addressReference;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public static Address fromDTO(AddressDTO addressDto) {
        return new Address(addressDto.getId(), addressDto.getStreetName(), addressDto.getStreetNum(),
                addressDto.getAddressReference(), addressDto.getCity(),
                addressDto.getState(), addressDto.getPostalCode());
    }

    public AddressDTO toDTO() {
        return new AddressDTO(id, streetName, streetNum, addressReference, city, state, postalCode);
    }

}
