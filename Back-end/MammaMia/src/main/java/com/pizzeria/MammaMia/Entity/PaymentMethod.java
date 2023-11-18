package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.PaymentMethodType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod extends AbstractEntity {
    @Column(name = "method_name")
    @Enumerated(EnumType.STRING)
    private PaymentMethodType methodName;
}
