package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "delivery")
public class Delivery extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "delivery_person_id")
    private DeliveryPerson deliveryPerson;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_delivery")
    private DeliveryStatus statusDelivery;

}
