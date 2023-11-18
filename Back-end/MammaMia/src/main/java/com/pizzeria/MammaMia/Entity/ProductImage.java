package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class ProductImage extends AbstractEntity {
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
