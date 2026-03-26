package com.example.project.repository;

import com.example.project.entity.Order;
import com.example.project.entity.OrderHasProduct;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @EntityGraph(attributePaths = {"orderHasProducts"})
    public Order findOrderById(Long id);
}
