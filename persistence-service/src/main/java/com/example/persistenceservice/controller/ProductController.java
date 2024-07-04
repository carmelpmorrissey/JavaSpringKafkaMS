package com.example.persistenceservice.controller;

import com.example.persistenceservice.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.persistenceservice.service.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/saveOrUpdate")
    public ResponseEntity<Void> saveOrUpdateProduct(@RequestBody Product product) {
        productService.saveOrUpdateProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }
    @PostMapping(value = "/getOne")
    public ResponseEntity<Product> getOneProduct(@RequestParam("productId") String productId) {
        Product product = productService.getProduct(Integer.parseInt(productId));
        return ResponseEntity.ok(product);
    }
    @PostMapping(value = "/delete/{productId}")
    public ResponseEntity<Void>  deleteProduct(@PathVariable(value = "productId", required = true) String productId) {
        productService.deleteProduct(Integer.parseInt(productId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
