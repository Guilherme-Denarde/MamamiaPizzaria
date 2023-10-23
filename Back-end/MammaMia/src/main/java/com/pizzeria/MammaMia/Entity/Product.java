package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_description")
    private String description;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "product_flavor")
    private Flavor flavor;

    private int quantity;

    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description, price, quantity, flavor);
    }
}
