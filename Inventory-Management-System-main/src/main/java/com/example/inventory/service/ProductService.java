package com.example.inventory.service;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }


    public Product save(Product p) {
        return repo.save(p);
    }

    public List<Product> getAll() {
        return repo.findAll();
    }


    public Product getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    public Product update(Long id, Product updatedProduct) {
        Product existing = getById(id);

        existing.setName(updatedProduct.getName());
        existing.setDescription(updatedProduct.getDescription());
        existing.setStockQuantity(updatedProduct.getStockQuantity());
        existing.setLowStockThreshold(updatedProduct.getLowStockThreshold());

        return repo.save(existing);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }

    // LOW STOCK LOGIC
    public List<Product> getLowStockProducts() {
        return repo.findAll()
                .stream()
                .filter(p -> p.getStockQuantity() < p.getLowStockThreshold())
                .toList();
    }
}