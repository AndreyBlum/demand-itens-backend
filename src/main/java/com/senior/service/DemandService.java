package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.Demand;
import com.senior.repository.DemandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DemandService {
    private final DemandRepository demandRepository;

    @Autowired
    public DemandService(DemandRepository demandRepository) {
        this.demandRepository = demandRepository;
    }

    public Demand add(Demand demand) {
        return demandRepository.save(demand);
    }

    public List<Demand> findAllDemand() {
        return demandRepository.findAll();
    }

    public Demand update(Long id, Demand demandUpdated) {
        Demand demand = this.findDemandId(id);

        demand.setAddress(demandUpdated.getAddress());
        demand.setClient(demandUpdated.getClient());
        demand.setTotalValue(demandUpdated.getTotalValue());
        demand.setSituation(demandUpdated.getSituation());
        demand.setDiscount(demandUpdated.getDiscount());

        return demandRepository.save(demand);
    }

    public Demand findDemandId(Long id) {
        return demandRepository.findDemandById(id)
                .orElseThrow(() -> new UserNotFoundException("Address by id " + id + " was not found"));
    }

    public void deleteDemand(Long id) {
        demandRepository.deleteDemandById(id);
    }
    public Page<Demand> findPage(Pageable pageable) {
        return demandRepository.findAll(pageable);
    }

}