package com.pizzeria.MammaMia.Repository;


import com.pizzeria.MammaMia.Entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
    RegisterUser findByEmail(String email);
}
