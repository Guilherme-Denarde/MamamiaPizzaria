package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "flavor")
public class Flavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flavor_name;
    private Float flavor_price;
    private String flavor_ingredients;

}
