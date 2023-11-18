package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Card extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String card_number;
    private String cardholder_name;
    @Temporal(TemporalType.DATE)
    private Date expiry_date;
    private String cvv;
    @OneToMany(mappedBy = "card")
    private Set<Payment> payments;


}
