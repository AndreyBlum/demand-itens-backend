package com.senior.model;

import com.senior.utils.DocType;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity(name = "legal_person")
public class LegalPerson extends Client {

	@CNPJ
	private String cnpj;

	public LegalPerson(){

	}

	public LegalPerson(String cnpj) {
		this.cnpj = cnpj;
	}

	public LegalPerson(Long id, String name, String clientCode, DocType docType, String cnpj) {
		super(id, name, clientCode, docType);
		this.cnpj = cnpj;
		this.setDocType(DocType.LEGAL);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
}
