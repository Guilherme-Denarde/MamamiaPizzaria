package com.pizzeria.mammaMia.Entity;


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
