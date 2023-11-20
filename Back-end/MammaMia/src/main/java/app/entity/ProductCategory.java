package app.entity;

import app.enums.CategoryType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategory extends AbstractEntity {
    @Enumerated(EnumType.STRING)
    @Column
    private CategoryType name;
    @OneToMany(mappedBy = "category")
    private Set<Product> products;

}
