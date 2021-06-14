package com.senior.controller;

import com.senior.dto.AddressDTO;
import com.senior.dto.DemandDTO;
import com.senior.dto.DemandItensDTO;
import com.senior.model.Address;
import com.senior.model.Client;
import com.senior.model.Demand;
import com.senior.service.AddressService;
import com.senior.service.ClientService;
import com.senior.service.DemandService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demand")
public class DemandController {

    @Autowired
    DemandService demandService;

    @Autowired
    ClientService clientService;

    @Autowired
    AddressService addressService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Demand> findById(@PathVariable(value="id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        Demand demand = demandService.findDemandId(id);

        return ResponseEntity.ok().body(demand);
    }

    @PostMapping("/add")
    public ResponseEntity<Demand> add(@RequestBody Demand demand) {
        Demand newDemand = demandService.add(demand);
        return new ResponseEntity<>(newDemand, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DemandDTO> update(@PathVariable Long id, @RequestBody Demand demand){

        DemandDTO demandDTO = new DemandDTO(demandService.update(id, demand));

        return ResponseEntity.ok().body(demandDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        demandService.deleteDemand(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public Page<Demand> findPage(Pageable pageable) {
        return demandService.findPage(pageable);
    }
}

