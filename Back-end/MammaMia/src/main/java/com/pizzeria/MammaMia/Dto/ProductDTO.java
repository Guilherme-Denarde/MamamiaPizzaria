package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Categoria;
import com.pizzeria.MammaMia.Entity.Sabor;
import com.pizzeria.MammaMia.Entity.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private Integer  stars;
    private Categoria categoria;
    private Boolean pizza;
    private Size tamanho;
    private List<Sabor> sabor;
}
