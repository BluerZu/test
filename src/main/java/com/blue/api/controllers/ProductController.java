package com.blue.api.controllers;

import com.blue.api.classes.Product;
import com.blue.api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(path="/")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

//    @PostMapping
    public void createProduct(Product product){
        this.productService.createProduct(product);
    }

}
