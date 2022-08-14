package com.etiya.northwind.dataAccess.abstracts;

import com.etiya.northwind.entities.concretes.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    
}
