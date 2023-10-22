package com.pizzeria.MammaMia.Dto;

import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.Entity.RegisterUser;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    private Long id;
    private RegisterUser registerUserId;
    private Address addressId;
    private String cpf;
    private String name;
    private String phone;


}
