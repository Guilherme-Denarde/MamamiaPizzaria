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
    private DeliveryPerson delivery_person;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private LocalDateTime deliveryTime;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus status_delivery;

}
