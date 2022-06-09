package com.example.clientmicroservice.services;


import com.example.clientmicroservice.models.Client;
import com.example.clientmicroservice.repositories.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private Repo repo;

    public Optional<Client> getById(long id) {
        return repo.findById(id).stream().findFirst();
    }

    public List<Client> getAll() {
        return repo.findAll();
    }

    public Client getByName(String name) {
        return repo.getByName(name);
    }

    public void save(Client client) {
        repo.save(client);
    }
}
