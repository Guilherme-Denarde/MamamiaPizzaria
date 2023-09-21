package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Payment payment;
    private OrderSize orderSize;
    private OrderState orderState;
    private boolean mustDelivery;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private Float priceTotal;
    private DeliveryPeople deliveryPeople;
    private Client client;
    private Employ employ;

    public OrderDTO() {}


}
