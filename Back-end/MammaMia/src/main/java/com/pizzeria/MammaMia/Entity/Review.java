package com.pizzeria.MammaMia.Entity;


import com.pizzeria.MammaMia.Enums.ReviewableType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private int rating;
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

}
