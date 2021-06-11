package com.senior.repository;

import com.senior.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemandRepository extends JpaRepository<Demand, Long> {

    Optional<Demand> findDemandById(Long id);

    void deleteDemandById(Long id);
}
