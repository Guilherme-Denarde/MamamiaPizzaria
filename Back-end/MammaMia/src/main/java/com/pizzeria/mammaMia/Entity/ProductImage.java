package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "product_image")
public class ProductImage extends AbstractEntity {
    @Column
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
