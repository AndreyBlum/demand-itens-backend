package com.senior.controller;

import com.senior.dto.AddressDTO;
import com.senior.model.Address;
import com.senior.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/id/{id}")
    public ResponseEntity<AddressDTO> findById(@PathVariable(value="id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        Address address = addressService.findAddressId(id);

        AddressDTO addressDTO = modelMapper.map(address,AddressDTO.class);

        return ResponseEntity.ok().body(addressDTO);
    }
    @GetMapping
    public Page<Address> findPage(Pageable pageable) {
        return addressService.findPage(pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<Address> add(@RequestBody Address address) {
        Address newAddress = addressService.add(address);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Long id, @RequestBody Address address) {

        AddressDTO addressDTO = new AddressDTO(addressService.update(id, address));

        return ResponseEntity.ok().body(addressDTO);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        addressService.deleteAdress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
