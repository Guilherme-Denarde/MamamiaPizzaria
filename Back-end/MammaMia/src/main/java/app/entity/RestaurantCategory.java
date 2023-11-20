package app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "restaurant_category")
public class RestaurantCategory extends AbstractEntity {
    @Column
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Restaurant> restaurants;
}
