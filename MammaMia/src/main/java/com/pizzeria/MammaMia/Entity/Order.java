package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
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
    private DeliveryPeople deliveryPeopleId;
    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "employ")
    private Employ employ;

    public OrderDTO toDTO() {
        return new OrderDTO(id, payment, orderSize, orderState, must_delivery, order_time, delivery_time, priceTotal, deliveryPeopleId, client, employ);
    }
}
