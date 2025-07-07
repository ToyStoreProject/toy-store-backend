package com.femcoders.toy_store_backend.services;

import com.femcoders.toy_store_backend.dtos.product.ProductMapper;
import com.femcoders.toy_store_backend.dtos.product.ProductResponse;
import com.femcoders.toy_store_backend.models.Product;
import com.femcoders.toy_store_backend.models.User;
import com.femcoders.toy_store_backend.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> ProductMapper.entityToDto(product)).toList();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(Product newProduct){
        return productRepository.save(newProduct);
    }

    public Product updateProduct(Product product, Product updatedProduct){
        product.setName(updatedProduct.getName());
        product.setImageUrl(updatedProduct.getImageUrl());
        product.setFeatured(updatedProduct.isFeatured());
        product.setPrice(updatedProduct.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
