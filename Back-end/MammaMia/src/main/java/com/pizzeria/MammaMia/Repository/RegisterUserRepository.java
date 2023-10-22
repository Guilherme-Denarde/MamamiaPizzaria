package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository extends JpaRepository<RegisterUser, Long> {
}
