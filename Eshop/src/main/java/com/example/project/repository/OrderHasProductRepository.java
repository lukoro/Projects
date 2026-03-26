package com.example.project.repository;

import com.example.project.entity.OrderHasProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHasProductRepository extends JpaRepository<OrderHasProduct,Long> {
}
