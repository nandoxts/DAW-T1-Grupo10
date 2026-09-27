package com.cibertec.feign.service;

import com.cibertec.feign.client.ProductClient;
import com.cibertec.feign.dto.ProductStoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductClient productClient;

    // Productos con precio mayor a 50.0 y categoría "electronics"
    public List<ProductStoreDto> getElectronicsMayorA50() {
        return productClient.getProducts().stream()
                .filter(p -> p.getPrice() != null && p.getPrice() > 50.0)
                .filter(p -> "electronics".equalsIgnoreCase(p.getCategory()))
                .toList();
    }
}
