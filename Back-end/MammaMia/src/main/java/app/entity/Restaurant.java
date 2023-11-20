package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "restaurant")
public class Restaurant extends AbstractEntity{
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String description;
    @Column
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
