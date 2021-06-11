package com.senior.dto;

import com.senior.model.Demand;
import com.senior.model.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class DemandItensDTO {

    private Long id;
    private Product product;
    private Demand demand;
    private int quantity;
    private BigDecimal totalValue;

    public DemandItensDTO() {
    }

    public DemandItensDTO(Long id, Product product, Demand demand, int quantity, BigDecimal totalValue) {
        this.id = id;
        this.product = product;
        this.demand = demand;
        this.quantity = quantity;
        this.totalValue = totalValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Demand getDemand() {
        return demand;
    }

    public void setDemand(Demand demand) {
        this.demand = demand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandItensDTO that = (DemandItensDTO) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(demand, that.demand) && Objects.equals(totalValue, that.totalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, demand, quantity, totalValue);
    }
}
