package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.STRING)
    private OrderSize orderSize;
    @Enumerated(EnumType.STRING)
    private  OrderState orderState;
    private boolean must_delivery;
    private Timestamp order_time;
    private Timestamp delivery_time;
    @Column(name = "pricetotal")
    private Float priceTotal;
    @ManyToOne
    @JoinColumn(name = "delivery_people")
    private DeliveryPeople delivery_people;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "employ")
    private Employ employ;

}
