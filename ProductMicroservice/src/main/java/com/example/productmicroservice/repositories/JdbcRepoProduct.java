package com.example.productmicroservice.repositories;

import com.example.productmicroservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcRepoProduct implements ProductDAO {

    private JdbcTemplate jdbcTemplate;

    private static final String QUERY = "select*from products";
    private static final String QUERY_BY_ID = "select*from products where id=?";

    private static final String QUERY_SAVE = "insert into products(name,barcode) values(?,?)";

    private static final String DELETE_BY_ID = "delete from products where id=?";

    @Autowired
    JdbcRepoProduct(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        jdbcTemplate.query(QUERY, new Object[]{}, (rs) -> {
            products.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3)));
        });
        return products;
    }

    @Override
    public Product getById(long id) {
        return jdbcTemplate.queryForObject(QUERY_BY_ID, new Object[]{id}, (rs, rowNum) -> {
            return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3));
        });
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_BY_ID, id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        jdbcTemplate.update(QUERY_SAVE, product.getId(),product.getName(),product.getBarcode());
    }
}
