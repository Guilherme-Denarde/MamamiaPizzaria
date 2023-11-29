package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private Payment payment;
    private OrderState orderState;
    private boolean mustDeliver;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private BigDecimal priceTotal;
    private DeliveryPeople deliveryPeople;
    private Client client;
    private Employ employ;
    private List<Product> items;

}
