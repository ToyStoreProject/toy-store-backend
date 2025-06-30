package com.femcoders.toy_store_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.femcoders.toy_store_backend.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
