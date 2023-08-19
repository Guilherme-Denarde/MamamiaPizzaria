package com.pizzeria.MammaMia.Dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Float price;
    private int productFlavor;
    private int quantity;
}
