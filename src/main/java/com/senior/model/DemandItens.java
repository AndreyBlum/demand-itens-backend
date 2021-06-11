package com.senior.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "demand_itens")
public class DemandItens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "demand_item_id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "demand_id", nullable = false, updatable = false)
    private Demand demand;
    @Column(name = "product_quantity")
    private int quantity;
    @Column(name = "total_product_value", nullable = false, updatable = false)
    private BigDecimal totalValue;

    public DemandItens() {
    }

    public DemandItens(Long id, Product product, Demand demand, int quantity, BigDecimal totalValue) {
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

    public Demand getOrder() {
        return demand;
    }

    public void setOrder(Demand order) {
        this.demand = order;
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
        DemandItens that = (DemandItens) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(product, that.product) && Objects.equals(demand, that.demand) && Objects.equals(totalValue, that.totalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, demand, quantity, totalValue);
    }

    @Override
    public String toString() {
        return "OrderItens{" +
                "id=" + id +
                ", product=" + product +
                ", demand=" + demand +
                ", quantity=" + quantity +
                ", totalValue=" + totalValue +
                '}';
    }
}
