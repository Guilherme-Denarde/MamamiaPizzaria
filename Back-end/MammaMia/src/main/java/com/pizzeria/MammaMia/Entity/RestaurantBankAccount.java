package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bank_account")
public class RestaurantBankAccount extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private String bankName;
    private String accountNumber;
    private String agencyNumber;
}
