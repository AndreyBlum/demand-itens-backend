package com.senior.controller;

import com.senior.dto.PhysicalPersonDTO;
import com.senior.dto.update.UpdatePhysicalDTO;
import com.senior.model.PhysicalPerson;
import com.senior.repository.PhysicalPersonRepository;
import com.senior.service.PhysicalPersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/physical")
public class PhysicalPersonController {

    @Autowired
    PhysicalPersonService physicalPersonService;

    @GetMapping("/id/{id}")
    public ResponseEntity<PhysicalPersonDTO> findById(@PathVariable(value = "id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        PhysicalPerson physicalPerson = physicalPersonService.findPhysicalPersonById(id);

        PhysicalPersonDTO physicalPersonDTO = modelMapper.map(physicalPerson, PhysicalPersonDTO.class);

        return ResponseEntity.ok().body(physicalPersonDTO);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PhysicalPerson>> findAll() {
        List<PhysicalPerson> physicals = physicalPersonService.findAllPhysicalPerson();
        return new ResponseEntity<>(physicals, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PhysicalPerson> add(@RequestBody PhysicalPerson physicalPerson) {
        PhysicalPerson newPhysicalPerson = physicalPersonService.add(physicalPerson);
        return new ResponseEntity<>(newPhysicalPerson, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhysicalPersonDTO> update(@PathVariable Long id, @RequestBody PhysicalPerson physicalPerson) {

        PhysicalPersonDTO physicalPersonDTO = new PhysicalPersonDTO(physicalPersonService.update(id, physicalPerson));

        return ResponseEntity.ok().body(physicalPersonDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        physicalPersonService.deletePhyicalPerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public Page<PhysicalPerson> findPage(Pageable pageable) {
        return physicalPersonService.findPage(pageable);
    }

}