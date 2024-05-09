package com.blue.api.controllers;

import com.blue.api.classes.Product;
import com.blue.api.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path="/get")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping(path="/create")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @PutMapping(path="/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product){
        return this.productService.createProduct(product);
    }

    @DeleteMapping(path="/delete/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productId") Long productId){
        return this.productService.deleteProduct(productId);
    }
}
