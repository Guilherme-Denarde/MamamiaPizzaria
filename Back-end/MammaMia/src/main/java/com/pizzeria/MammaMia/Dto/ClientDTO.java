package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.security.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Integer id;
    private User registerUserId;
    private Address addressId;
    private String cpf;
    private String name;
    private String phone;


}
