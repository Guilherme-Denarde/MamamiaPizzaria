package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import com.pizzeria.MammaMia.Enums.OrderSize;
import com.pizzeria.MammaMia.Enums.ProcessingStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod payment;

    @Enumerated(EnumType.STRING)
    private OrderSize orderSize;

    @Enumerated(EnumType.STRING)
    private ProcessingStatus orderState;

    @Column(name = "must_deliver")
    private boolean mustDeliver;

    @Column(name = "order_time")
    private Timestamp orderTime;

    @Column(name = "delivery_time")
    private Timestamp deliveryTime;

    @Column(name = "pricetotal", precision = 10, scale = 2)
    private BigDecimal priceTotal;

    @ManyToOne
    @JoinColumn(name = "delivery_people")
    private DeliveryPeople deliveryPeople;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    public OrderDTO toDTO() {
        return new OrderDTO(id, payment, orderSize, orderState, mustDeliver, orderTime, deliveryTime, priceTotal, deliveryPeople, client);
    }
}
