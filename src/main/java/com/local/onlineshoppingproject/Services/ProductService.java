package com.local.onlineshoppingproject.Services;

import com.local.onlineshoppingproject.DTOs.ProductUpdateDTO;
import com.local.onlineshoppingproject.Entities.Category;
import com.local.onlineshoppingproject.Entities.Product;
import com.local.onlineshoppingproject.Repositories.CategoryRepo;
import com.local.onlineshoppingproject.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    @Autowired
    public ProductService(ProductRepo productRepo, CategoryRepo categoryRepo) {
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    public List<Product> showAllProdcuts() {
        return productRepo.findAll();
    }

    public List<Product> findByCategoryId(int categoryId) {
        return productRepo.findByCategoryId(categoryId);
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public Product addNewProduct() {
        return productRepo.save(new Product());
    }

    public Product updateThatProduct(int productId, ProductUpdateDTO productDTO) {
        Optional<Product> productOptional = productRepo.findById(productId);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product not found with ID: " + productId);
        }

        Product product = productOptional.get();


        Optional<Category> categoryOptional = categoryRepo.findById(productDTO.getCategoryId());
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found with ID: " + productDTO.getCategoryId());
        }

        Category category = categoryOptional.get();


        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategory(category);

        return productRepo.save(product);
    }


    public Product getProduct(Integer id) {
        return productRepo.getProductById(id);
    }
    public void deleteThatProduct() {
        productRepo.deleteById(productRepo.findAll().get(0).getId());
    }



}
