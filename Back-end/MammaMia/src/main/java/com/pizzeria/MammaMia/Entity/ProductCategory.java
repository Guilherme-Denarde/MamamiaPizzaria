package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.CategoryType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
public class ProductCategory extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    private CategoryType name;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}
