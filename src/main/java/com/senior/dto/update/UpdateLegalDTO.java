package com.senior.dto.update;

import com.senior.model.LegalPerson;
import com.senior.repository.LegalPersonRepository;
import com.senior.utils.CpfCnpjValidation;
import com.senior.utils.DocType;

import java.util.Optional;

public class UpdateLegalDTO {

    private String name;
    private String cnpj;
    private DocType docType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public Optional<LegalPerson> update(Long id, LegalPersonRepository legalPersonRepository) {
        LegalPerson legalPerson = legalPersonRepository.getOne(id);


        if (CpfCnpjValidation.isValid(cnpj)) {
            legalPerson.setName(this.name);
            legalPerson.setCnpj(this.cnpj);

            if (cnpj.length() == 11) {
                legalPerson.setDocType(DocType.PHYSICAL);
            }
            else {
                legalPerson.setDocType(DocType.LEGAL);
            }
            return Optional.of(legalPerson);
        }
        return Optional.empty();
    }

}

