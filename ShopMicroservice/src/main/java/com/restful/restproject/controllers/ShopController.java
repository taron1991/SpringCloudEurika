package com.restful.restproject.controllers;

import com.restful.restproject.models.Client;
import com.restful.restproject.models.Orders;
import com.restful.restproject.models.Product;
import com.restful.restproject.models.Shop;
import com.restful.restproject.otherConfigs.RestTemplateComponent;
import com.restful.restproject.services.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Basic class processing queries and interacting with microservices
 */
@RestController
@RequestMapping("/shop")
@Slf4j
public class ShopController {

    private Service service;
    private RestTemplateComponent restTemplateComponent;
    private static final String URL_CLIENT = "http://localhost:8282/client";
    private static final String URL_PRODUCT = "http://localhost:8180/product";

    @Autowired
    public ShopController(Service service, RestTemplateComponent restTemplateComponent) {
        this.restTemplateComponent = restTemplateComponent;
        this.service = service;
    }

    /**
     * searching orders from client(from another microservice)
     *
     * @param clientId
     * @param productId
     * @return Orders
     */
    @GetMapping("/getOrders")
    public Orders getOrdersFromClient(@RequestParam("clientId") long clientId,
                                      @RequestParam("productId") long productId,
                                      @RequestParam("shopId") long id) {

        log.info("in the method");

        Shop shop = service.getShopById((int) id).get();
        Client client = restTemplateComponent.loadBalanced().getForObject(URL_CLIENT + "/byId/" + clientId, Client.class);
        Product product = restTemplateComponent.loadBalanced().getForObject(URL_PRODUCT + "/byId/" + productId, Product.class);

        Orders orders = new Orders();
        orders.setClient(client);
        orders.setShop(shop);
        orders.setProduct(product);

        log.info("list successfully derived");
        return orders;
    }

    /**
     * saving or updating client from another microservice
     *
     * @param id
     * @param name
     * @param client
     */
    @PostMapping("/saveUpdateClient")
    public void addOrUpdateClient(@RequestParam("id") Long id, @RequestParam("name") String name,
                                  Client client) {
        ResponseEntity<String> rsp = restTemplateComponent.loadBalanced().postForEntity(URL_CLIENT + "/saveClient" + "/" + id + "/" + name,
                client, String.class);
        System.out.println(rsp.getBody());
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProductById(@RequestParam("id") Long id) {
        if (id == null) {
            log.error("there's no such a product");
        } else {
            restTemplateComponent.loadBalanced().delete(URL_PRODUCT + "/deleteId/" + id);
            log.info("id {} successfully deleted ", id);
        }
    }
    /**
     * @param id
     * @return ResponseEntity
     * can be also done with getForObject();
     */
    @GetMapping("/byId")
    public Client findById(@RequestParam("id") Long id) {
        log.info("in the method");
        ResponseEntity<Client> forEntity = null;
        if (id == null) {
            log.error("there's no such a client with id {}", id);
            return null;
        } else {
            forEntity = restTemplateComponent.loadBalanced().getForEntity(URL_CLIENT + "/byId/" + id, Client.class);
            log.info("Client successfully found with id {}", id);

        }
        return forEntity.getBody();
    }

}

