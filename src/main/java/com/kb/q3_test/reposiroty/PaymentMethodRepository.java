package com.kb.q3_test.reposiroty;

import com.kb.q3_test.modal.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
    public PaymentMethod findByName(String paymentMethod);
}
