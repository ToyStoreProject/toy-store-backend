package com.femcoders.toy_store_backend.dtos.product;

import com.femcoders.toy_store_backend.models.Product;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto){
        return new Product(dto.name(),dto.imageUrl(),dto.featured(),dto.price());
    }

    public static ProductResponse entityToDto (Product product) {
        return new ProductResponse(product.getName(), product.getImageUrl(), product.isFeatured(), product.getPrice());

    }
}
