package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.EmployDTO;
import com.pizzeria.MammaMia.Dto.FlavorDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "flavor")
@AllArgsConstructor
@NoArgsConstructor
public class Flavor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    private String ingredients;

    public FlavorDTO toDTO() {
        return new FlavorDTO(id, name, price, ingredients);
    }
}
