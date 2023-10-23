package com.pizzeria.MammaMia.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Integer id;
    private Integer clientId;
    private Integer productId;
    private Integer orderId;
    private int rating;
    private String comment;
    private Timestamp reviewTime;
}
