package com.senior.controller;

import com.senior.dto.LegalPersonDTO;
import com.senior.dto.update.UpdateLegalDTO;
import com.senior.model.LegalPerson;
import com.senior.repository.LegalPersonRepository;
import com.senior.service.LegalPersonService;
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
@RequestMapping("/legal")
public class LegalPersonController {

    @Autowired
    LegalPersonService legalPersonService;

    @Autowired
    LegalPersonRepository legalPersonRepository;

    @GetMapping("/id/{id}")
    public ResponseEntity<LegalPersonDTO> findById(@PathVariable(value="id") Long id) {

        ModelMapper modelMapper = new ModelMapper();

        LegalPerson legalPerson = legalPersonService.findLegalPersonById(id);

        LegalPersonDTO legalPersonDTO = modelMapper.map(legalPerson,LegalPersonDTO.class);

        return ResponseEntity.ok().body(legalPersonDTO);
    }
    @GetMapping("/all")
    public ResponseEntity<List<LegalPerson>> findAll() {
        List<LegalPerson> legals = legalPersonService.findAllLegalPerson();
        return new ResponseEntity<>(legals, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<LegalPerson> add(@RequestBody LegalPerson legalPerson) {
        LegalPerson newlegalPerson = legalPersonService.add(legalPerson);
        return new ResponseEntity<>(newlegalPerson, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LegalPersonDTO> update(@PathVariable Long id, @RequestBody LegalPerson legalPerson){

        LegalPersonDTO legalPersonDTO = new LegalPersonDTO(legalPersonService.update(id, legalPerson));

        return ResponseEntity.ok().body(legalPersonDTO);
    }
    @PutMapping("/test/{id}")
    @Transactional
    public ResponseEntity<LegalPersonDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateLegalDTO updateLegal){
        Optional<LegalPerson> userSearch = legalPersonRepository.findById(id);

        if(userSearch.isPresent()) {
            Optional<LegalPerson> user = updateLegal.update(id, legalPersonRepository);
            return ResponseEntity.ok(new LegalPersonDTO(user));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        legalPersonService.deleteLegalPerson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping
    public Page<LegalPerson> findPage(Pageable pageable) {
        return legalPersonService.findPage(pageable);
    }

}