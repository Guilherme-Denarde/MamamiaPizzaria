package com.pizzeria.MammaMia.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
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

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

}
