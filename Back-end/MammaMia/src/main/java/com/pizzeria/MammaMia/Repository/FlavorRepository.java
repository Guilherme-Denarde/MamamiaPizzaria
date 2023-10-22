package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.Flavor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends JpaRepository<Flavor, Long> {
}
