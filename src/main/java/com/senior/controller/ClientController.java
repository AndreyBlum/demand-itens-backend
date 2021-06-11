package com.senior.controller;

import com.senior.dto.ClientDTO;
import com.senior.model.Client;
import com.senior.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable(value = "id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        Client client = clientService.findClientById(id);

        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);

        return ResponseEntity.ok().body(clientDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> findAll() {
        List<Client> clients = clientService.findAllClient();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Client> add(@RequestBody Client client) {
        Client newClient = clientService.add(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody Client client) {

        ClientDTO clientDTO = new ClientDTO(clientService.update(id, client));

        return ResponseEntity.ok().body(clientDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Page<Client> findPage(Pageable pageable) {
        return clientService.findPage(pageable);
    }

}