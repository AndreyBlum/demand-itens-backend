package com.senior.repository;

import com.senior.model.DemandItens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemandItensRepository extends JpaRepository<DemandItens, Long> {

    Optional<DemandItens> findDemandItensById(Long id);

    void deleteDemandItensById(Long id);
}
