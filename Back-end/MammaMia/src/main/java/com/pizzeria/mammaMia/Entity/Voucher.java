package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;


@Entity
@Data
@Table(name = "voucher")
public class Voucher extends AbstractEntity {
    @Column
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
