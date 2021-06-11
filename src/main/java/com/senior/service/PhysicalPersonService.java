package com.senior.service;

import com.senior.exception.UserNotFoundException;
import com.senior.model.LegalPerson;
import com.senior.model.PhysicalPerson;
import com.senior.repository.PhysicalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PhysicalPersonService {
    private final PhysicalPersonRepository physicalPersonRepository;

    @Autowired
    public PhysicalPersonService(PhysicalPersonRepository physicalPersonRepository) {
        this.physicalPersonRepository = physicalPersonRepository;
    }

    public PhysicalPerson add(PhysicalPerson physicalPerson) {
        return physicalPersonRepository.save(physicalPerson);
    }

    public List<PhysicalPerson> findAllPhysicalPerson() {
        return physicalPersonRepository.findAll();
    }

    public PhysicalPerson update(Long id, PhysicalPerson physicalUpdated) {
        PhysicalPerson physicalPerson = this.findPhysicalPersonById(id);

        physicalPerson.setCpf(physicalUpdated.getCpf());
        physicalPerson.setName(physicalUpdated.getName());
        physicalPerson.setDocType(physicalUpdated.getDocType());
        physicalPerson.setClientCode(physicalPerson.getClientCode());

        return physicalPersonRepository.save(physicalPerson);
    }


    public PhysicalPerson findPhysicalPersonById(Long id) {
        return physicalPersonRepository.findPhysicalPersonById(id)
                .orElseThrow(() -> new UserNotFoundException("Client by id " + id + " was not found"));
    }

    public void deletePhyicalPerson(Long id) {
        physicalPersonRepository.deletePhysicalPersonById(id);
    }

    public PhysicalPerson physicalGetOne(Long id) {
        return physicalPersonRepository.getOne(id);
    }

    public Page<PhysicalPerson> findPage(Pageable pageable) {
        return physicalPersonRepository.findAll(pageable);
    }
}
