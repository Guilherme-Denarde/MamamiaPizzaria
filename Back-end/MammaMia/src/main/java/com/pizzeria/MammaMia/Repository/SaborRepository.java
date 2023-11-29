package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
    Sabor findByNome(String name);
}
