package com.femcoders.toy_store_backend.services;

import com.femcoders.toy_store_backend.models.Category;
import com.femcoders.toy_store_backend.models.Product;
import com.femcoders.toy_store_backend.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category addCategory(Category newCategory){
        return categoryRepository.save(newCategory);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Category category, Category updatedCategory){
        category.setName(updatedCategory.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}
