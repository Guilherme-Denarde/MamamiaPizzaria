package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Address")
public class Address extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_num")
    private int streetNum;
    private String additionalInfo;
    private Boolean isDefault;
    private String city;
    private String state;
    private String postalCode;



}
