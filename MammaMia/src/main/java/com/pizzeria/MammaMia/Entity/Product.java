package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private String product_description;
    private Float price;
    private int product_flavor;
    private int quantity;

}
