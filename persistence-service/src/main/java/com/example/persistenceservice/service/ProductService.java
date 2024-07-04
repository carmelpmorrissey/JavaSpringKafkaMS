package com.example.persistenceservice.service;

import com.example.persistenceservice.dao.ProductRepository;
import com.example.persistenceservice.entity.Product;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public void saveOrUpdateProduct(Product product) {
        log.info("Inserting product object");
        productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        log.info("Finding product objects");
        return productRepository.findAll();
    }
    public Product getProduct(int productId) {
        log.info("Finding product id {}", productId);
        return productRepository.findById(productId).orElse(null);
    }
    public void deleteProduct(Product product) {
        log.info("Deleting product id {}", product.getProductId());
        productRepository.delete(product);
    }
    public void deleteProduct(int productId) {
        log.info("Deleting product id {}", productId);
        productRepository.deleteById(productId);
    }
}
