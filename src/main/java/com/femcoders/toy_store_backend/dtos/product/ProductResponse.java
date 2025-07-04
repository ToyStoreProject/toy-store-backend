package com.femcoders.toy_store_backend.dtos.product;

import jakarta.validation.constraints.*;

public record ProductResponse(
    String name,
    String imageUrl,
    Boolean featured,
    Double price
) {
}
