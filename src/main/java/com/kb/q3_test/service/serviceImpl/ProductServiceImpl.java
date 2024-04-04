package com.kb.q3_test.service.serviceImpl;

import com.kb.q3_test.modal.Product;
import com.kb.q3_test.reposiroty.ProductRepository;
import com.kb.q3_test.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    private ProductRepository productService;
    @Override
    public List<Product> getAllProducts() {

        return productService.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productService.findById(id).orElse(null);
    }
}
