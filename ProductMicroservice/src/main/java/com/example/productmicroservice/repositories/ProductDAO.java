package com.example.productmicroservice.repositories;

import com.example.productmicroservice.models.Product;

import java.util.List;

public interface ProductDAO {

    List<Product> getAll();
    Product getById(long id);
    void deleteById(long id);
    void saveOrUpdate(Product product);
}
