package com.example.project;

import com.example.project.entity.Order;
import com.example.project.entity.OrderHasProduct;
import com.example.project.entity.Product;
import com.example.project.entity.StateEnum;
import com.example.project.repository.OrderHasProductRepository;
import com.example.project.repository.OrderRepository;
import com.example.project.repository.ProductRepository;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderHasProductRepository orderHasProductRepository;


    @Test
    void saveProductTest() {
        Product product=new Product();

        product.setProductName("MyProduct");

        productRepository.save(product);

        Product product2=new Product();

        product2.setProductName("MyProduct2");

        productRepository.save(product2);



    }


}
