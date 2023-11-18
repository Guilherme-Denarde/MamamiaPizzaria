package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.CategoryType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class ProductCategory extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private CategoryType name;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}
