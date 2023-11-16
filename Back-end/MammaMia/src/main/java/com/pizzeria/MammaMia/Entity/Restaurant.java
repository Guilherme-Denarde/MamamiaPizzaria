package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
public class Restaurant {

    private String name;
    private String email;
    private String phone;
    private String description;
    private Float rating_average;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

}
