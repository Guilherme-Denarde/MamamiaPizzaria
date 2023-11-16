package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.PaymentMethodType;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod extends AbstractEntity {
    private PaymentMethodType method_name;
}
