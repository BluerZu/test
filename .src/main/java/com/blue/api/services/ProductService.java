package com.blue.api.services;

import com.blue.api.classes.Product;
import com.blue.api.interfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public void createProduct(Product product){
        this.productRepository.save(product);
    }

}