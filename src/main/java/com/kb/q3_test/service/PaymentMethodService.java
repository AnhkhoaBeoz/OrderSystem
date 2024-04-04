package com.kb.q3_test.service;

import com.kb.q3_test.modal.PaymentMethod;

public interface PaymentMethodService {

    public PaymentMethod findByName(String paymentMethod);
}
