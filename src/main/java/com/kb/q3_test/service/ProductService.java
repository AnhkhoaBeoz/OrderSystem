package com.kb.q3_test.service;

import com.kb.q3_test.modal.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
}
