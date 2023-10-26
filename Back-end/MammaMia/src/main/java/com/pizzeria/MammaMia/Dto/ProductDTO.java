package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Flavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;
    private Flavor flavor;
    private String imageUrl;
    private Integer  stars;
}
