package com.restful.restproject.services;

import com.restful.restproject.models.Shop;
import com.restful.restproject.repositories.ShopRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@NoArgsConstructor
public class Service {

    public ShopRepository shopRepository;

    @Autowired
    public Service(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Optional<Shop> getShopById(int id) {
        return shopRepository.findById(id);
    }

}