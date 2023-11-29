package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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

    @Column(name = "image_url")
    private String imageUrl;

    private Integer  stars;

    @Enumerated(EnumType.ORDINAL)
    private Categoria categoria;

    private Boolean pizza;

    @ManyToOne
    @JoinColumn(name = "tamanho_id")
    private Size tamanho;

    @ManyToMany
    private List<Sabor> sabor;


    public ProductDTO toDTO() {
        return new ProductDTO(id, name, description, price,imageUrl,stars,categoria,pizza,tamanho,sabor);
    }
}
