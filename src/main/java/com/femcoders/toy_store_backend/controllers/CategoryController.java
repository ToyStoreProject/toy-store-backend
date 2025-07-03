package com.femcoders.toy_store_backend.controllers;

import com.femcoders.toy_store_backend.models.Category;
import com.femcoders.toy_store_backend.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @PostMapping
    public void addCategory(@RequestBody Category newCategory) {
        categoryService.addCategory(newCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
        Category existingCategory = categoryService.getCategoryById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with ID: " + id));
        Category updatedCategory = categoryService.updateCategory(existingCategory, categoryDetails);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        Category existingCategory = categoryService.getCategoryById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found with ID: " + id));
        categoryService.deleteCategory(existingCategory);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
