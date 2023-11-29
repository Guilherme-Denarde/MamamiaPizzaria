package com.pizzeria.MammaMia.security.auth;

import com.pizzeria.MammaMia.Entity.Address;
import com.pizzeria.MammaMia.security.user.Role;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {


  // CLIENT
  private Address address;
  private String cpf;
  private String name;
  private String phone;

  //USER
  private String email;
  private String password;
  private Role role;
}
