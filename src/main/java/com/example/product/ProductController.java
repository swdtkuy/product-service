package com.example.product;

import com.example.product.model.Product;
import com.example.product.repository.ProductMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @Autowired
    private ProductMapper productMapper;

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getProducts(){
        // Product product = new Product("product1","specification1","id1");
        ArrayList<Product> products = new ArrayList<>();
        // products.add(product);
        logger.info("retrieve all products.");
        try {
            productMapper.getAllProducts().forEach(products::add);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch(Exception e) {
            logger.error("system error", e);
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
}
