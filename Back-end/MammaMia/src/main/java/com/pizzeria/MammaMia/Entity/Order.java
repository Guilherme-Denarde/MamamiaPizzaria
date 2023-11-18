package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "order")
public class Order extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "requires_delivery")
    private boolean requiresDelivery;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "delivery_address_id")
    private Address deliveryAddress;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_time")
    private Date orderTime;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> orderItems;
    @OneToMany(mappedBy = "order")
    private Set<OrderStatus> orderStatus;
}
