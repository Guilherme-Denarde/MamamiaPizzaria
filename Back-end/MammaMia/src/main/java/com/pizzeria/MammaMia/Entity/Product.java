package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.OrderSize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product extends AbstractEntity{

    private String name;
    private String description;
    private Float price;
    private int like;
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private OrderSize size;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
    private Boolean available;
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;


}
