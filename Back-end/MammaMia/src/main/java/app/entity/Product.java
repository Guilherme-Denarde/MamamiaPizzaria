package app.entity;

import app.enums.OrderSize;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product extends AbstractEntity{
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private Float price;
    @Column
    private int like;
    @Column
    private Boolean discount;
    @Column(name = "discount_price")
    private Float discountPrice;
    @Enumerated(EnumType.STRING)
    @Column(name = "size")
    private OrderSize size;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column
    private Boolean available;
    @OneToMany(mappedBy = "product")
    private Set<ProductImage> productImages;
    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;


}
