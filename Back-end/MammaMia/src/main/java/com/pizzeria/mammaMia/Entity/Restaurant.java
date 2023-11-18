package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Restaurant extends AbstractEntity{

    private String name;
    private String email;
    private String phone;
    private String description;
    private Float rating_average;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantImage> restaurantImages;
    @OneToMany(mappedBy = "restaurant")
    private Set<RestaurantHours> restaurantHours;
    @ManyToMany
    @JoinTable(
            name = "restaurant_restaurant_category",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<RestaurantCategory> categories;

}
