package app.entity;

import app.enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "payment_method")
public class PaymentMethod extends AbstractEntity {
    @Column(name = "method_name")
    @Enumerated(EnumType.STRING)
    private PaymentMethodType methodName;
}
