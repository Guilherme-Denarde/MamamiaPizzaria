package com.pizzeria.MammaMia.security.auth;

import com.pizzeria.MammaMia.Dto.AddressDTO;
import com.pizzeria.MammaMia.security.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


  // CLIENT
  private AddressDTO address;
  private String cpf;
  private String name;
  private String phone;

  //USER
  private String email;
  private String password;
  private Role role;
}
