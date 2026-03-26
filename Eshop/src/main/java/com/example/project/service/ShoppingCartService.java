package com.example.project.service;

import com.example.project.entity.Product;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

public interface ShoppingCartService {

    void add(Long id);

    void remove(Long id);

    Map<Product, Integer> getCart();

    void checkout();
}
