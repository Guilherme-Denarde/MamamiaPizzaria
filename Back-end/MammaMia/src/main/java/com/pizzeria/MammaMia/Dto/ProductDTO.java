package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Flavor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Integer id;
    private String productName;
    private String productDescription;
    private BigDecimal price;
    private int quantity;
    private Flavor flavor;
}
