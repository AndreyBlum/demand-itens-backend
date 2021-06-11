package com.senior.dto;

import com.senior.model.Product;
import com.senior.utils.StatusEnum;

import java.util.Objects;

public class ProductDTO {

    private Long id;
    private String description;
    private String unitOfmeasurement;
    private double unitaryValue;
    private int code;
    private int totalAmount;
    private StatusEnum status;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String description, String unitOfmeasurement, double unitaryValue, int code, int totalAmount, StatusEnum status) {
        this.id = id;
        this.description = description;
        this.unitOfmeasurement = unitOfmeasurement;
        this.unitaryValue = unitaryValue;
        this.code = code;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public ProductDTO(Product update) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return Double.compare(that.unitaryValue, unitaryValue) == 0 && code == that.code && totalAmount == that.totalAmount && Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(unitOfmeasurement, that.unitOfmeasurement) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, unitOfmeasurement, unitaryValue, code, totalAmount, status);
    }
}
