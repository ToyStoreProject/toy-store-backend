package com.femcoders.toy_store_backend.dtos.product;

public record ProductResponse(
        String name,
        String imageUrl,
        Boolean featured,
        Double price
) {
}