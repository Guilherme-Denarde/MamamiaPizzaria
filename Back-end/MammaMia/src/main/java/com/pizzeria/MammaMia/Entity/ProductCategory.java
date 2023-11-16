package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.CategoryType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory extends AbstractEntity {
    private CategoryType name;

}
