package com.example.project;

import com.example.project.entity.Product;
import com.example.project.repository.OrderHasProductRepository;
import com.example.project.repository.OrderRepository;
import com.example.project.repository.ProductRepository;
import com.example.project.service.ShoppingCartService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SHoppingCartTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Test
    void addOneToShoppingCart() {
        Product product = new Product();
        product.setProductName("product1");

        productRepository.save(product);
        List<Product> all = productRepository.findAll();

        Long firstId = all.get(all.size() - 1).getId();

        shoppingCartService.add(firstId);



        assertEquals(1, shoppingCartService.getCart().size());

        assertTrue(shoppingCartService.getCart().containsKey(all.get(all.size() - 1)));

        assertEquals(shoppingCartService.getCart().get(all.get(all.size() - 1)), 1);

        shoppingCartService.add(firstId);

        assertEquals(shoppingCartService.getCart().get(all.get(all.size() - 1)), 2);

        //   assertEquals(shoppingCartService.getShoppingCart().get(all.get(sumAll + 1).getProductName()), "product1");

        shoppingCartService.remove(firstId);

        assertEquals(shoppingCartService.getCart().get(all.get(all.size() - 1)), 1);


        shoppingCartService.remove(firstId);

        assertEquals(0, shoppingCartService.getCart().size());

    }




}
