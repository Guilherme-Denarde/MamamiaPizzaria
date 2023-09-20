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
public class ClientDTO {
    private Long id;
    private Long registerUserId;
    private Long addressId;
    private String cpf;
    private String name;
    private String phone;

    public ClientDTO(Long id, Long registerUserId, Long addressId, String cpf, String name, String phone) {
        this.id = id;
        this.registerUserId = registerUserId;
        this.addressId = addressId;
        this.cpf = cpf;
        this.name = name;
        this.phone = phone;
    }
}
