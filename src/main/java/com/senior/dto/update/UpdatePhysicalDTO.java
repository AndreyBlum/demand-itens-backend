package com.senior.dto.update;

import com.senior.model.PhysicalPerson;
import com.senior.repository.PhysicalPersonRepository;
import com.senior.service.PhysicalPersonService;
import com.senior.utils.CpfCnpjValidation;
import com.senior.utils.DocType;

import java.util.Optional;

public class UpdatePhysicalDTO {

    private String name;
    private String cpf;
    private DocType docType;


    public Optional<PhysicalPerson> update(Long id, PhysicalPersonRepository physicalPersonRepository) {
        PhysicalPerson physicals = physicalPersonRepository.getOne(id);

        if (CpfCnpjValidation.isValid(cpf)) {
            physicals.setName(this.name);
            physicals.setCpf(this.cpf);

            if (cpf.length() == 11) {
                physicals.setDocType(DocType.PHYSICAL);
            }
            else {
                physicals.setDocType(DocType.LEGAL);
            }
            return Optional.of(physicals);
        }
        return Optional.empty();
    }
}
