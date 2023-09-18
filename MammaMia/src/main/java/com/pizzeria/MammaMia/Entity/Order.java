package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Dto.OrderDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public OrderSize getOrderSize() {
        return orderSize;
    }

    public void setOrderSize(OrderSize orderSize) {
        this.orderSize = orderSize;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public boolean isMust_delivery() {
        return must_delivery;
    }

    public void setMust_delivery(boolean must_delivery) {
        this.must_delivery = must_delivery;
    }

    public Timestamp getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Timestamp order_time) {
        this.order_time = order_time;
    }

    public Timestamp getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Timestamp delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public DeliveryPeople getDelivery_people() {
        return delivery_people;
    }

    public void setDelivery_people(DeliveryPeople delivery_people) {
        this.delivery_people = delivery_people;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employ getEmploy() {
        return employ;
    }

    public void setEmploy(Employ employ) {
        this.employ = employ;
    }
}
