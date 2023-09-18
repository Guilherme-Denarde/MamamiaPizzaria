package com.pizzeria.MammaMia.Dto;

import lombok.Data;

@Data
public class FlavorDTO {
    private Long id;
    private String flavorName;
    private Float flavorPrice;
    private String flavorIngredients;

    public FlavorDTO() {}

    public FlavorDTO(Long id, String flavorName, Float flavorPrice, String flavorIngredients) {
        this.id = id;
        this.flavorName = flavorName;
        this.flavorPrice = flavorPrice;
        this.flavorIngredients = flavorIngredients;
    }
}
