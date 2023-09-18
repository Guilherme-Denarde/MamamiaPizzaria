package com.pizzeria.MammaMia.Dto;
import com.pizzeria.MammaMia.Entity.OrderSize;
import com.pizzeria.MammaMia.Entity.OrderState;
import com.pizzeria.MammaMia.Entity.Payment;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.STRING)
    private OrderSize orderSize;
    @Enumerated(EnumType.STRING)
    private OrderState orderState;
    private boolean mustDelivery;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private Float priceTotal;
    private Long deliveryPeopleId;
    private Long clientId;
    private Long employId;

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

    public boolean isMustDelivery() {
        return mustDelivery;
    }

    public void setMustDelivery(boolean mustDelivery) {
        this.mustDelivery = mustDelivery;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Timestamp getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Timestamp deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Float getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(Float priceTotal) {
        this.priceTotal = priceTotal;
    }

    public Long getDeliveryPeopleId() {
        return deliveryPeopleId;
    }

    public void setDeliveryPeopleId(Long deliveryPeopleId) {
        this.deliveryPeopleId = deliveryPeopleId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployId() {
        return employId;
    }

    public void setEmployId(Long employId) {
        this.employId = employId;
    }
}
