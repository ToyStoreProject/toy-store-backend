package com.femcoders.toy_store_backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotBlank(message = "Name cannot be blank")
    @Size(max = 50, message = "Name cannot be longer than 50 characters")
    private String name;

    @Pattern(
            regexp = "^(https?://.*\\.(?:png|jpg|jpeg|gif|bmp|webp))$",
            message = "The URL must to be valid and with an image extension (png, jpg, jpeg, gif, bmp, webp)"
    )
    private String imageUrl;

    private boolean featured;

    @Positive
    @NotNull(message = "The price must be between 0.01 and 9999.99")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "9999.99")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CartItem> cartItems = new ArrayList<>();

    public Product(String name, String imageUrl, boolean featured, double price){
        this.name= name;
        this.imageUrl = imageUrl;
        this.featured=featured;
        this.price=price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
