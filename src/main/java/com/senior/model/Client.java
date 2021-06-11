package com.senior.model;

import com.senior.utils.DocType;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "client")
@Inheritance(strategy = InheritanceType.JOINED)
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false, updatable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "code", nullable = false, updatable = false)
    private String clientCode;
    @Enumerated(EnumType.STRING)
    @Column(name = "doc_type", nullable = false)
    private DocType docType;

    public Client() {
    }

    public Client(Long id, String name, String clientCode, DocType docType) {
        this.id = id;
        this.name = name;
        this.clientCode = clientCode;
        this.docType = docType;
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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }
}