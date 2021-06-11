package com.senior.model;

import com.senior.utils.DocType;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "physical_person")
public class PhysicalPerson extends Client {

	@CPF
	private String cpf;

	public PhysicalPerson() {

	}

	public PhysicalPerson(String cpf) {
		this.cpf = cpf;
	}

	public PhysicalPerson(Long id, String name, String clientCode, DocType docType, String cpf) {
		super(id, name, clientCode, docType);
		this.cpf = cpf;
		this.setDocType(DocType.PHYSICAL);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}