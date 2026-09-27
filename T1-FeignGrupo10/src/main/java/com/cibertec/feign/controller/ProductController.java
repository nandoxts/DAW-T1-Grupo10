package com.cibertec.feign.controller;

import com.cibertec.feign.dto.ProductStoreDto;
import com.cibertec.feign.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductStoreDto> getProducts() {
        return productService.getElectronicsMayorA50();
    }
}
