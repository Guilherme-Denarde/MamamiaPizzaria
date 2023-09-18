package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.OrderSize;
import com.pizzeria.MammaMia.Entity.OrderState;
import com.pizzeria.MammaMia.Entity.Payment;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDTO {
    private Long id;
    private Payment payment;
    private OrderSize orderSize;
    private OrderState orderState;
    private boolean mustDelivery;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private Float priceTotal;
    private Long deliveryPeopleId;
    private Long clientId;
    private Long employId;

    public OrderDTO() {}

    public OrderDTO(Long id,
                    Payment payment,
                    OrderSize orderSize,
                    OrderState orderState,
                    boolean mustDelivery,
                    Timestamp orderTime,
                    Timestamp deliveryTime,
                    Float priceTotal,
                    Long deliveryPeopleId,
                    Long clientId,
                    Long employId)
    {
        this.id = id;
        this.payment = payment;
        this.orderSize = orderSize;
        this.orderState = orderState;
        this.mustDelivery = mustDelivery;
        this.orderTime = orderTime;
        this.deliveryTime = deliveryTime;
        this.priceTotal = priceTotal;
        this.deliveryPeopleId = deliveryPeopleId;
        this.clientId = clientId;
        this.employId = employId;
    }
}
