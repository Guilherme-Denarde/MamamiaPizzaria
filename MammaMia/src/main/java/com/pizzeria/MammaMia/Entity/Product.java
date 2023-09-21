package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "product_description")
    private String description;
    private Float price;
//    private int productFlavor;
    @JoinColumn(name = "product_flavor")
    @ManyToOne
    private Flavor flavor;
    private int quantity;

    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description, price, quantity, flavor);
    }

}
