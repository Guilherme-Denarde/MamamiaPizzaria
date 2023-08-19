package com.pizzeria.MammaMia.Dto;
import lombok.Data;

import java.sql.Timestamp;
@Data
public class OrderDTO {
    private Long id;
    private String payment;
    private String orderSize;
    private String orderState;
    private boolean mustDelivery;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private Float priceTotal;
    private Long deliveryPeopleId;
    private Long clientId;
    private Long employId;

    public OrderDTO() {}



}
