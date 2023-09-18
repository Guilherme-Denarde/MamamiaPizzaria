package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.OrderDTO;
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
    public OrderDTO toDTO() {
        OrderDTO dto = new OrderDTO();
        dto.setId(this.id);
        dto.setPayment(this.payment);
        dto.setOrderSize(this.orderSize);
        dto.setOrderState(this.orderState);
        dto.setMustDelivery(this.must_delivery);
        dto.setOrderTime(this.order_time);
        dto.setDeliveryTime(this.delivery_time);
        dto.setPriceTotal(this.priceTotal);
        dto.setDeliveryPeopleId(this.delivery_people != null ? this.delivery_people.getId() : null);
        dto.setClientId(this.client != null ? this.client.getId() : null);
        dto.setEmployId(this.employ != null ? this.employ.getId() : null);
        return dto;
    }

}
