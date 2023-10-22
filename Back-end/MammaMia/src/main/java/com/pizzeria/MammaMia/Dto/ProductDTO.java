package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Flavor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String productName;
    private String productDescription;
    private Float price;

//    private int productFlavor;
    private int quantity;
    private Flavor flavor;




}
