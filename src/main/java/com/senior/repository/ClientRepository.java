package com.senior.repository;

import com.senior.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientById(Long id);

    void deleteClientById(Long id);
}
