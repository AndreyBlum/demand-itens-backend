package com.senior.dto;

import com.senior.model.PhysicalPerson;
import com.senior.utils.DocType;

import java.util.Objects;
import java.util.Optional;

public class PhysicalPersonDTO extends ClientDTO {

    private String cpf;

    public PhysicalPersonDTO() {

    }

    public PhysicalPersonDTO(String cpf) {
        this.cpf = cpf;
    }

    public PhysicalPersonDTO(Long id, String name, String code, DocType docType, String cpf) {
        super(id, name, code, docType);
        this.cpf = cpf;
    }

    public PhysicalPersonDTO(PhysicalPerson user) {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhysicalPersonDTO that = (PhysicalPersonDTO) o;
        return Objects.equals(cpf, that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cpf);
    }
}