package app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "address")
public class Address extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_num")
    private int streetNum;
    @Column
    private String country;
    @Column(name = "additional_info")
    private String additionalInfo;
    @Column(name = "is_default")
    private Boolean isDefault;
    @Column
    private String city;
    @Column
    private String state;
    @Column(name = "postal_code")
    private String postalCode;

}
