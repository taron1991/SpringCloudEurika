package com.example.productmicroservice.services;

import com.example.productmicroservice.models.Product;
import com.example.productmicroservice.repositories.JdbcRepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public JdbcRepoProduct jdbcRepoProduct;

    @Autowired
    ProductService(JdbcRepoProduct jdbcRepoProduct){this.jdbcRepoProduct = jdbcRepoProduct;}

    public List<Product> getAll(){
        return jdbcRepoProduct.getAll();
    }

    public Product getById(long id){
        return jdbcRepoProduct.getById(id);
    }


    public void save(Product product){
        jdbcRepoProduct.saveOrUpdate(product);
    }

    public void deleteProduct(long id){
        jdbcRepoProduct.deleteById(id);
    }
}

