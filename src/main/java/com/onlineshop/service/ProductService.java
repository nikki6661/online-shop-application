package com.onlineshop.service;


import com.onlineshop.exception.ProductNotFoundException;
import com.onlineshop.model.product;
import com.onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }

    public product createProduct(product product) {
        return productRepository.save(product);
    }

    public List<product> findAll() {

        return productRepository.findAll();
    }

    public product updateProduct(product productEntity, String ID) {
        if (productRepository.existsById(ID)) {
            productEntity.setId(ID);
            return productRepository.save(productEntity);
        } else throw new ProductNotFoundException(ID);
    }

    public void deleteProduct(String ID) {
        if (productRepository.existsById(ID)) {
            productRepository.deleteById(ID);
        } else throw new ProductNotFoundException(ID);
    }
}
