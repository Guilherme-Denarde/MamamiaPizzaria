package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.PaymentMethodType;
import com.pizzeria.MammaMia.Enums.PaymentStatusEnum;
import com.pizzeria.MammaMia.Enums.ProcessingStatus;
import jakarta.persistence.*;

@Entity
public class Payment extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    private Float amount;
    @ManyToOne
    @JoinColumn(name = "payment_method_id" )
    private PaymentMethod paymentMethod;
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
}
