package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.DemandItens;
import com.senior.repository.DemandItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DemandItensService {
    private final DemandItensRepository demandItensRepository;

    @Autowired
    public DemandItensService(DemandItensRepository demandItensRepository) {
        this.demandItensRepository = demandItensRepository;
    }

    public DemandItens add(DemandItens demandItens) {
        return demandItensRepository.save(demandItens);
    }

    public List<DemandItens> findAllDemandItens() {
        return demandItensRepository.findAll();
    }

    public DemandItens updateDemandItens(DemandItens demandItens) {
        return demandItensRepository.save(demandItens);
    }

    public DemandItens findDemandItensId(Long id) {
        return demandItensRepository.findDemandItensById(id)
                .orElseThrow(() -> new UserNotFoundException("Demand Itens by id " + id + " was not found"));
    }

    public void deleteDemandItens(Long id) {
        demandItensRepository.deleteDemandItensById(id);
    }
}