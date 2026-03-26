package com.example.project.controller;

import com.example.project.dto.AddorEditProductDto;
import com.example.project.entity.Product;
import com.example.project.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ExceptionHandler(RuntimeException.class)
    public String handleException() {
        return "error";
    }


    @GetMapping("/")
    public String showAllProducts(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "product-list";
    }

    @GetMapping(value ={"/product-form", "/product-form/{id}"})
    public String showProductForm(@PathVariable(required = false) Long id, Model model) {
        AddorEditProductDto dto = new AddorEditProductDto();

        if (id != null) {
            Product product = productRepository.findById(id).orElseThrow();
            dto.setId(product.getId());
            dto.setProductName(product.getProductName());
        }

        model.addAttribute("product", dto);

        return "product-form";
    }

    @PostMapping("/product-form-process")
    public String productFormProcess(AddorEditProductDto addorEditProductDto) {
        Product product = new Product();
        product.setProductName(addorEditProductDto.getProductName());
        product.setId(addorEditProductDto.getId());

        productRepository.save(product);

        return "redirect:/";
    }

    @GetMapping("/product-detail/{id}")
    public String showProductDetail(@PathVariable(required = false) Long id, Model model) {

        try {
            model.addAttribute("product", productRepository.findById(id).get());
            return "product-detail";
        } catch (Exception e) {
            return "error";
        }

    }

}

