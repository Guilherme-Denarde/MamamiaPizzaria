package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
