package com.senior.controller;

import com.senior.dto.DemandItensDTO;
import com.senior.model.DemandItens;
import com.senior.service.DemandItensService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandItens")
public class DemandItensController {

    @Autowired
    DemandItensService demandItensService;

    @GetMapping("/id/{id}")
    public ResponseEntity<DemandItensDTO> findById(@PathVariable(value="id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        DemandItens demandItens = demandItensService.findDemandItensId(id);

        DemandItensDTO demandItensDTO = modelMapper.map(demandItensService,DemandItensDTO.class);

        return ResponseEntity.ok().body(demandItensDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<DemandItens>> findAll() {
        List<DemandItens> demandManyItens = demandItensService.findAllDemandItens();
        return new ResponseEntity<>(demandManyItens, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DemandItens> add(@RequestBody DemandItens demandItens) {
        DemandItens newDemandItens = demandItensService.add(demandItens);
        return new ResponseEntity<>(newDemandItens, HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<DemandItens> update(@RequestBody DemandItens demandItens) {
        DemandItens update = demandItensService.updateDemandItens(demandItens);
        return new ResponseEntity<>(update, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        demandItensService.deleteDemandItens(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}