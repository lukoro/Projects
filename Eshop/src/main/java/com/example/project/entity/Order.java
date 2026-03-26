package com.example.project.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "orderForm")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StateEnum state;

    @OneToMany(mappedBy = "id")
    private Set<OrderHasProduct> orderHasProducts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public Set<OrderHasProduct> getOrderHasProducts() {
        return orderHasProducts;
    }

    public void setOrderHasProducts(Set<OrderHasProduct> orderHasProducts) {
        this.orderHasProducts = orderHasProducts;
    }
}
