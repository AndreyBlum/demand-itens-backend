package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.LegalPerson;
import com.senior.model.PhysicalPerson;
import com.senior.repository.LegalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LegalPersonService {
    private final LegalPersonRepository legalPersonRepository;

    @Autowired
    public LegalPersonService(LegalPersonRepository legalPersonRepository) {
        this.legalPersonRepository = legalPersonRepository;
    }

    public LegalPerson add(LegalPerson legalPerson) {
        legalPerson.setClientCode(UUID.randomUUID().toString());
        return legalPersonRepository.save(legalPerson);
    }

    public List<LegalPerson> findAllLegalPerson() {
        return legalPersonRepository.findAll();
    }

    public LegalPerson findLegalPersonById(Long id) {
        return legalPersonRepository.findLegalPersonById(id)
                .orElseThrow(() -> new UserNotFoundException("Client by id " + id + " was not found"));
    }

    public Page<LegalPerson> findPage(Pageable pageable) {
        return legalPersonRepository.findAll(pageable);
    }

    public void deleteLegalPerson(Long id) {
        legalPersonRepository.deleteLegalPersonById(id);
    }

    public LegalPerson update(Long id, LegalPerson legalUpdated) {
        LegalPerson legalPerson = this.findLegalPersonById(id);

        legalPerson.setCnpj(legalUpdated.getCnpj());
        legalPerson.setName(legalUpdated.getName());
        legalPerson.setDocType(legalUpdated.getDocType());
        legalPerson.setClientCode(legalUpdated.getClientCode());

        return legalPersonRepository.save(legalPerson);
    }
}
