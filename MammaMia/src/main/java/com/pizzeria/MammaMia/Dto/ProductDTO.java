package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Flavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class ProductDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Float price;
    private int productFlavor;
    private int quantity;
    private Flavor flavor;

    public ProductDTO(Long id, String name, String description, Float price, Flavor flavor, int quantity) {}

//    public ProductDTO(Long id, String productName, String productDescription, Float price, int productFlavor, int quantity,Flavor flavor) {
//        this.id = id;
//        this.productName = productName;
//        this.productDescription = productDescription;
//        this.price = price;
//        this.productFlavor = productFlavor;
//        this.quantity = quantity;
//        this.flavor = flavor;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getProductFlavor() {
        return productFlavor;
    }

    public void setProductFlavor(int productFlavor) {
        this.productFlavor = productFlavor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }
}
