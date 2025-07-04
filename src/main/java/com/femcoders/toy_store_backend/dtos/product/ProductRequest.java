package com.femcoders.toy_store_backend.dtos.product;

import jakarta.validation.constraints.*;

public record ProductRequest (
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 50, message = "Name cannot be longer than 50 characters")
        String name,
        @Pattern(
                regexp = "^(https?://.*\\.(?:png|jpg|jpeg|gif|bmp|webp))$",
                message = "The URL must to be valid and with an image extension (png, jpg, jpeg, gif, bmp, webp)"
        )
        @NotBlank(message = "URL cannot be blank")
        String imageUrl,
        @NotBlank(message = "You must mark as featured or not featured")
        Boolean featured,
        @Positive
        @NotNull(message = "The price must be between 0.01 and 9999.99")
        @DecimalMin(value = "0.01")
        @DecimalMax(value = "9999.99")
        Double price
) {
}
