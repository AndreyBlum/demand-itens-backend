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

    public DemandDTO(Demand update) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public SituationEnum getSituation() {
        return situation;
    }

    public void setSituation(SituationEnum situation) {
        this.situation = situation;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}