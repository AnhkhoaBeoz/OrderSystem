package com.kb.q3_test.service.serviceImpl;

import com.kb.q3_test.modal.PaymentMethod;
import com.kb.q3_test.reposiroty.PaymentMethodRepository;
import com.kb.q3_test.service.PaymentMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodImpl implements PaymentMethodService {


    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public PaymentMethod findByName(String paymentMethod) {
        return paymentMethodRepository.findByName(paymentMethod);
    }
}
