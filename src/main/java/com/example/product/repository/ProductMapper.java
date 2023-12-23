package com.example.product.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.product.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    
    @Select("SELECT * FROM products")
    List<Product> getAllProducts();
}