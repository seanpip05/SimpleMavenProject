package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product created = productService.createProduct(product);
        return ResponseEntity.status(201).body(created); // HTTP 201 Created
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products); // HTTP 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        if (updated != null) {
            return ResponseEntity.ok(updated); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        if (deleted) {
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
}
