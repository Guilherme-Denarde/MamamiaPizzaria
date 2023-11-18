package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.StatusOrder;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderStatus extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "order_status")
    @Enumerated(EnumType.STRING)
    private StatusOrder OrderStatuses;
}
