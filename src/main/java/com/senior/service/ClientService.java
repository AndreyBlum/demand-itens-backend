package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.Client;
import com.senior.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client add(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    public Client update(Long id, Client client) {
        Client clientUpdated = this.findClientById(id);

        client.setClientCode(clientUpdated.getClientCode());
        client.setName(clientUpdated.getName());
        client.setDocType(clientUpdated.getDocType());

        return clientRepository.save(client);
    }


    public Client findClientById(Long id) {
        return clientRepository.findClientById(id)
                .orElseThrow(() -> new UserNotFoundException("Client by id " + id + " was not found"));
    }

    public void deleteClient(Long id) {
        clientRepository.deleteClientById(id);
    }

    public Client clientGetOne(Long id) {
        return clientRepository.getOne(id);
    }

    public Page<Client> findPage(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
