package com.pizzeria.MammaMia.Entity;

import com.pizzeria.MammaMia.Enums.DayOfWeek;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;

@Entity
@Data
public class RestaurantHours extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @Column(name = "day_of_week")
    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;
    @Column(name = "open_time")
    private Time openTime;
    @Column(name = "close_time")
    private Time closeTime;
}
