package com.pizzeria.MammaMia.Repository;

import com.pizzeria.MammaMia.Entity.Categoria;
import com.pizzeria.MammaMia.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByCategoria(Categoria categoria);


}
