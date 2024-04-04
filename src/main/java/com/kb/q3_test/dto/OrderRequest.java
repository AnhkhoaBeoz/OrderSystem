package com.kb.q3_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private Long userId;
    private String shippingAddress;
    private String shippingMethod;
    private String paymentMethod;
    private Long productId;
    private int quantity;


}