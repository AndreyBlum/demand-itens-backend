package com.senior.repository;

import com.senior.model.Client;
import com.senior.model.PhysicalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhysicalPersonRepository extends JpaRepository<PhysicalPerson, Long> {

    Optional<PhysicalPerson> findPhysicalPersonById(Long id);

    void deletePhysicalPersonById(Long id);
}
