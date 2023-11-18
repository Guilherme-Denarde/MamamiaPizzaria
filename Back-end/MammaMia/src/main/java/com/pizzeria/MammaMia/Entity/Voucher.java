package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import java.util.Date;


@Entity
@Data
public class Voucher extends AbstractEntity {
    private String description;
    @Column(name = "discount_rate")
    private Float discountRate;
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

}
