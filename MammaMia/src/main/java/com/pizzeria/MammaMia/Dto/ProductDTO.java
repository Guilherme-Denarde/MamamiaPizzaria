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

    public ProductDTO() {}

    public ProductDTO(Long id, String productName, String productDescription, Float price, int productFlavor, int quantity) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.productFlavor = productFlavor;
        this.quantity = quantity;
    }

}
