package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.security.Timestamp;
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
