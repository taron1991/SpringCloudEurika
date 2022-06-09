package com.example.productmicroservice.controllers;

import com.example.productmicroservice.models.Product;

import com.example.productmicroservice.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Product
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private ProductService productService;

    @Autowired
    ProductController(ProductService productService){this.productService=productService;}

    /**
     * Method gets all products from DB
     * @return
     */
    @RequestMapping("/all")
    public List<Product> getProducts(){
        List<Product> all = productService.getAll();
        log.info("suucess");
        return all;
    }

    /**
     * Method get product by id
     * @return
     */
    @GetMapping("/byId/{val}")
    public Product getById(@PathVariable("val") Long id){
        return productService.getById(id);
    }

    /**
     * Method saves or updates product
     * @return
     */
    @PostMapping("/saveUpdate")
    public void saveOrUpdate(@RequestBody Product product){
        productService.save(product);
    }

    /**
     * Method deletes a product by id from DB
     * @return
     */
    @DeleteMapping("/deleteId/{id}")
    public void deleteProduct(@PathVariable("id") long id){
        productService.deleteProduct(id);
    }
}

