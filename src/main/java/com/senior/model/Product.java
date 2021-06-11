package com.senior.model;

import com.senior.utils.StatusEnum;

import javax.persistence.*;

@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    private String description;
    @Column(name = "unit_of_measurement")
    private String unitOfmeasurement;
    @Column(name = "unitary_value")
    private double unitaryValue;
    @Column(name = "product_code", nullable = false)
    private int code;
    @Column(name = "total_amount")
    private int totalAmount;
    @Enumerated(EnumType.STRING)
    @Column(name = "status_type", nullable = false)
    private StatusEnum status;

    public Product(Long id, String description, String unitOfmeasurement, double unitaryValue, int code, int totalAmount, StatusEnum status) {
        this.id = id;
        this.description = description;
        this.unitOfmeasurement = unitOfmeasurement;
        this.unitaryValue = unitaryValue;
        this.code = code;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public Product(int code) {
        this.code = code;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfmeasurement() {
        return unitOfmeasurement;
    }

    public void setUnitOfmeasurement(String unitOfmeasurement) {
        this.unitOfmeasurement = unitOfmeasurement;
    }

    public double getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(double unitaryValue) {
        this.unitaryValue = unitaryValue;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

}