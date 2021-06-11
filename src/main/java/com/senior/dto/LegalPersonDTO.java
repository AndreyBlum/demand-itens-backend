package com.senior.dto;

import com.senior.model.Demand;
import com.senior.model.LegalPerson;
import com.senior.utils.DocType;

import java.util.List;
import java.util.Optional;

public class LegalPersonDTO extends ClientDTO {

    private String cnpj;

    public LegalPersonDTO() {

    }

    public LegalPersonDTO(String cnpj) {
        this.cnpj = cnpj;
    }

    public LegalPersonDTO(Long id, String name, String code, DocType docType, String cnpj) {
        super(id, name, code, docType);
        this.cnpj = cnpj;
    }

    public LegalPersonDTO(Long id, String name, String code, DocType docType, List<Demand> demands, String cnpj) {
        super(id, name, code, docType, demands);
        this.cnpj = cnpj;
    }

    public LegalPersonDTO(LegalPerson update) {

	}

    public LegalPersonDTO(Optional<LegalPerson> user) {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}