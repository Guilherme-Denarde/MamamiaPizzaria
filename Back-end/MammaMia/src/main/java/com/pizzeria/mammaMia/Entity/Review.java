package com.pizzeria.mammaMia.Entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class Review extends AbstractEntity {
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private int rating;
    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

}
