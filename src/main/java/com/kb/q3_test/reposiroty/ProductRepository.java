package com.kb.q3_test.reposiroty;

import com.kb.q3_test.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
