package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByClient( Client client);
}
