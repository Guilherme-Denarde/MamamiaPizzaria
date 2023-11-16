package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.*;
import com.pizzeria.MammaMia.Enums.OrderSize;
import com.pizzeria.MammaMia.Enums.ProcessingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Integer id;
    private PaymentMethod payment;
    private OrderSize orderSize;
    private ProcessingStatus orderState;
    private boolean mustDeliver;
    private Timestamp orderTime;
    private Timestamp deliveryTime;
    private BigDecimal priceTotal;
    private DeliveryPeople deliveryPeople;
    private Client client;
}
