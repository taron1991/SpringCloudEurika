package com.example.clientmicroservice.repositories;

import com.example.clientmicroservice.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<Client,Long> {

    @Query(value = "select * from client where name =:name",nativeQuery = true)
    Client getByName(@Param("name") String name);
}

