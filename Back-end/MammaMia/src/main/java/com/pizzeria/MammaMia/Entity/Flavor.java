package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.FlavorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "flavor")
@AllArgsConstructor
@NoArgsConstructor
public class Flavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "flavor_name")
    private String name;

    @Column(name = "flavor_price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "flavor_ingredients")
    private String ingredients;

    public FlavorDTO toDTO() {
        return new FlavorDTO(id, name, price, ingredients);
    }
}
