package com.example.clientmicroservice.controllers;

import com.example.clientmicroservice.models.Client;
import com.example.clientmicroservice.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Service Client
 */
@RestController
@RequestMapping("/client")
@Slf4j
public class ClientController {

    @Autowired
    private ClientService clientService;

    /**
     * method searching a client by id
     * @param id
     * @return
     */
    @GetMapping("/byId/{val}")
    public Optional<Client> getById(@PathVariable("val") long id){
        if(clientService.getById(id)==null){
            log.info("there's no such a client with id{}",id);
        }else{
            log.info("client has successfully been added with id{}",id);
        }
        return clientService.getById(id);
    }

    /**
     * Method gets all clients
     * @return
     */
    @GetMapping("/getAll")
    public List<Client> getAll(){
        return clientService.getAll();
    }


    /**
     * Method gets client by name
     * @param name
     * @return
     */
    @GetMapping("/byName/{name}")
    public Client getByName(@PathVariable("name") String name){
        if(clientService.getByName(name)==null){
            log.info("there's no such a client with name{}",name);
        }else{
            log.info("client has successfully been added with name{}",name);
        }
        return clientService.getByName(name);
    }

    /**
     * Method saves a client
     * @param id
     * @param name
     */
    @PostMapping("/saveClient/{id}/{name}")
    public void saveUpdate(@PathVariable("id") Long id,@PathVariable("name") String name){
        if(id == null || name==null){
            log.info("error saving a client");
        }

        Client client = new Client(id,name);
        log.info("successfully saved a client");
        clientService.save(client);
    }
}
