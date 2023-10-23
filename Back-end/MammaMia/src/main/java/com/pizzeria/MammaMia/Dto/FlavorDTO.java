package com.pizzeria.MammaMia.Dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FlavorDTO {
    private Integer id;
    private String flavorName;
    private BigDecimal  flavorPrice;
    private String flavorIngredients;

    public FlavorDTO() {}

    public FlavorDTO(Integer id, String flavorName, BigDecimal flavorPrice, String flavorIngredients) {
        this.id = id;
        this.flavorName = flavorName;
        this.flavorPrice = flavorPrice;
        this.flavorIngredients = flavorIngredients;
    }
}
