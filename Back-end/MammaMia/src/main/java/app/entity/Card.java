package app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "card")
public class Card extends AbstractEntity{
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "cardholder_name")
    private String cardholder_name;
    @Temporal(TemporalType.DATE)
    @Column(name = "expiry_date")
    private Date expiryDate;
    @Column
    private String cvv;
    @OneToMany(mappedBy = "card")
    private Set<Payment> payments;


}
