package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "bank_account")
public class RestaurantBankAccount extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "agency_number")
    private String agencyNumber;
}
