package com.senior.repository;

import com.senior.model.LegalPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {

    Optional<LegalPerson> findLegalPersonById(Long id);

    void deleteLegalPersonById(Long id);
}
