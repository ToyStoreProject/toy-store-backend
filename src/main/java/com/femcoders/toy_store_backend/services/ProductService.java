package com.femcoders.toy_store_backend.services;

import com.femcoders.toy_store_backend.dtos.product.ProductResponse;
import com.femcoders.toy_store_backend.models.Product;
import com.femcoders.toy_store_backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
}
