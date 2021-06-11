package com.senior.controller;

import com.senior.dto.DemandDTO;
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
    public ResponseEntity<DemandDTO> findById(@PathVariable(value="id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        Demand demand = demandService.findDemandId(id);

        DemandDTO demandDTO = modelMapper.map(demand,DemandDTO.class);

        return ResponseEntity.ok().body(demandDTO);
    }
//    @GetMapping
//    public ResponseEntity<List<Demand>> findAll() {
//        List<Demand> demands = demandService.findAllDemand();
//        return new ResponseEntity<>(demands, HttpStatus.OK);
//    }
    @PostMapping
    public ResponseEntity<Demand> add(@RequestBody DemandDTO demandDTO) {
        Demand demand = new Demand();
        Long addressId = new Long(demandDTO.getAddress());
        Long clientId = new Long(demandDTO.getClient());
        Client client = clientService.findClientById(clientId);
        Address address = addressService.findAddressId(addressId);
        demand.setAddress(address);
        demand.setClient(client);
        demand.setDate(demandDTO.getDate());
        demand.setId(demandDTO.getId());
        demand.setDiscount(demandDTO.getDiscount());
        demand.setSituation(demandDTO.getSituation());
        demand.setTotalValue(demandDTO.getTotalValue());
        demand.setDemandItens(demandDTO.getDemandItens());
        demandService.add(demand);

        return new ResponseEntity<>(demand, HttpStatus.CREATED);

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

