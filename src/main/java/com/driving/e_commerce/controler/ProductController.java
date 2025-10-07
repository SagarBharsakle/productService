package com.driving.e_commerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.driving.e_commerce.entity.Product;
import com.driving.e_commerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService psi;

    @PostMapping("/add")
    public ResponseEntity<Product> setProduct(@RequestBody Product p) {
        logger.info("Received request to add product: {}", p);

        Product addProduct = psi.addProduct(p);
        logger.info("Product added successfully with ID: {}", addProduct.getId());

        return new ResponseEntity<>(addProduct, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Product>> getAllProduct() {
        logger.info("Received request to fetch all products");

        List<Product> productList = psi.getProduct();
        logger.info("Number of products retrieved: {}", productList.size());

        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> update(@PathVariable String id, @RequestBody Product p) {
        logger.info("Received request to update product with ID: {}", id);
        logger.debug("Updated product details: {}", p);

        Product updatedProduct = psi.updatedproduct(id, p);
        logger.info("Product with ID {} updated successfully", id);

        return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {
        logger.info("Received request to delete product with ID: {}", id);

        String message = psi.delete(id);
        logger.info("Deletion result for product ID {}: {}", id, message);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
