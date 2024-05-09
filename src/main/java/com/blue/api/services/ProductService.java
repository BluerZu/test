package com.blue.api.services;

import com.blue.api.classes.Product;
import com.blue.api.interfaces.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Object> createProduct(Product product){
        Optional<Product> res = productRepository.findProductByName(product.getName());
        HashMap<String, Object> data = new HashMap<>();
        if(res.isPresent() && product.getId() == null) {
            String message = "El producto " + product.getName() + " ya existe en la base de datos.";
            data.put("data", false);
            data.put("response", message);
//            throw new IllegalStateException(message);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }else if (product.getId() != null) {
            String message = "El producto se actualizó correctamente.";
            data.put("data", product);
            data.put("response", message);
            this.productRepository.save(product);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.ACCEPTED
            );
        } else {
            String message = "El producto se ha creado correctamente.";
            data.put("data", product);
            data.put("response", message);
            this.productRepository.save(product);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.CREATED
            );
        }
    }

    public ResponseEntity<Object> deleteProduct(Long productId){
        if (this.productRepository.existsById(productId)){
            String message = "El producto con el id " + productId + " se ha eliminado correctamente.";
            HashMap<String, Object> data = new HashMap<>();
            data.put("data", true);
            data.put("response", message);
            this.productRepository.deleteById(productId);
            return new ResponseEntity<>(
                    data,
                    HttpStatus.ACCEPTED
            );
        } else {
            String message = "El producto con el id " + productId + " no existe.";
            HashMap<String, Object> data = new HashMap<>();
            data.put("data", false);
            data.put("response", message);

            return new ResponseEntity<>(
                    data,
                    HttpStatus.CONFLICT
            );
        }

    }

}