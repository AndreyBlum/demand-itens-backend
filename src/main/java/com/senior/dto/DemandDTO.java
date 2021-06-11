package com.senior.dto;

import com.senior.model.Demand;
import com.senior.model.DemandItens;
import com.senior.utils.SituationEnum;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class DemandDTO {

    private Long id;
    private String client;
    private String address;
    private LocalDate date;
    private SituationEnum situation;
    private BigDecimal totalValue;
    private double discount;
    private List<DemandItens> demandItens;

    public DemandDTO() {
    }

    public DemandDTO(Long id, String client, String address, LocalDate date, SituationEnum situation, BigDecimal totalValue, double discount) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.date = date;
        this.situation = situation;
        this.totalValue = totalValue;
        this.discount = discount;
    }

    public DemandDTO(Long id, String client, String address, LocalDate date, SituationEnum situation, BigDecimal totalValue, double discount, List<DemandItens> demandItens) {
        this.id = id;
        this.client = client;
        this.address = address;
        this.date = date;
        this.situation = situation;
        this.totalValue = totalValue;
        this.discount = discount;
        this.demandItens = demandItens;
    }

    public DemandDTO(Demand update) {
    }

    public List<DemandItens> getDemandItens() {
        return demandItens;
    }

    public void setDemandItens(List<DemandItens> demandItens) {
        this.demandItens = demandItens;
    }

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDate() {
        return date;
    }

    public SituationEnum getSituation() {
        return situation;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public double getDiscount() {
        return discount;
    }
}