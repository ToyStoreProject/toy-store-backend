package com.femcoders.toy_store_backend.controllers;

import com.femcoders.toy_store_backend.services.CartService;
import com.femcoders.toy_store_backend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{userId}/add/{productId}")
    public ResponseEntity<?> addProductToCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.addProduct(userId, productId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{userId}/delete/{productId}")
    public ResponseEntity<?> deleteProductFromCart(@PathVariable Long userId, @PathVariable Long productId) {
        cartService.deleteProduct(userId, productId);
        return ResponseEntity.ok().build();
    }
}