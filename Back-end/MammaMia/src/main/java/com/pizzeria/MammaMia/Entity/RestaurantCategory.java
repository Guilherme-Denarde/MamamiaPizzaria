package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class RestaurantCategory extends AbstractEntity {
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Restaurant> restaurants;
}
