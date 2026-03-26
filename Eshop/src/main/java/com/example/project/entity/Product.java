package com.example.project.entity;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String productName;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private Set<OrderHasProduct> productsInOrders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String name) {
        this.productName = name;
    }

    public Set<OrderHasProduct> getProductsInOrders() {
        return productsInOrders;
    }

    public void setProductsInOrders(Set<OrderHasProduct> productsInOrders) {
        this.productsInOrders = productsInOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }
}
