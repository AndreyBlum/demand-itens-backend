package com.senior.dto;

import com.senior.model.Client;
import com.senior.model.Demand;
import com.senior.utils.DocType;

import java.util.List;
import java.util.Objects;

public class ClientDTO {

    private Long id;
    private String name;
    private String code;
    private DocType docType;
    private List<Demand> demands;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String code, DocType docType, List<Demand> demands) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.docType = docType;
        this.demands = demands;
    }

    public ClientDTO(Long id, String name, String code, DocType docType) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.docType = docType;
    }

    public ClientDTO(Client update) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id) && Objects.equals(name, clientDTO.name) && Objects.equals(code, clientDTO.code) && docType == clientDTO.docType && Objects.equals(demands, clientDTO.demands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, docType, demands);
    }
}
