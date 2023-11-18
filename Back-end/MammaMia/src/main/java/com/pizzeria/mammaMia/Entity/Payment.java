package com.pizzeria.mammaMia.Entity;

import com.pizzeria.mammaMia.Enums.PaymentStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "payment")
public class Payment extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;
    @Column
    private Float amount;
    @ManyToOne
    @JoinColumn(name = "payment_method_id" )
    private PaymentMethod paymentMethod;
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum paymentStatus;
}
