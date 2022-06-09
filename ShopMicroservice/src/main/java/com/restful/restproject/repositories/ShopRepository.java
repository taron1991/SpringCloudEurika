package com.restful.restproject.repositories;

import com.restful.restproject.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Repository
public interface ShopRepository extends JpaRepository<Shop,Integer> {

    Shop findByName(String name);

    @Query(value = "select * from shop where stuff >:more",nativeQuery = true)
    List<Shop> getMoreThan(@Param("more") Integer more);

}