package com.pizzeria.MammaMia.Repository;


import com.pizzeria.MammaMia.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
