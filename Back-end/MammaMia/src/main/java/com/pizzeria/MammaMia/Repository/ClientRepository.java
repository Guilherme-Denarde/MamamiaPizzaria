package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.Client;
import com.pizzeria.MammaMia.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByUser(User user);
}
