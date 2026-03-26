package com.example.project.repository;

import com.example.project.entity.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("select p from Product p where p.id between 1 and 2")
    Product findProductByIdBetween(Long start, Long finish);

    @EntityGraph(attributePaths = {"productsInOrders"})
    Product findProductByProductNameContaining(String contains);

}
