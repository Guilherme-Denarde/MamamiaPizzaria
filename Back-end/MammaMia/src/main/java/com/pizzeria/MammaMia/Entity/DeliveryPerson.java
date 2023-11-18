package com.pizzeria.mammaMia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "delivery_person")
public class DeliveryPerson extends AbstractEntity {
    private String name;
    private String phone;
    private String vehicleType;
    private Float latitude;
    private Float longitude;

}
