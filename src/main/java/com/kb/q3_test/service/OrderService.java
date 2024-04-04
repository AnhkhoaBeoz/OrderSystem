package com.kb.q3_test.service;

import com.kb.q3_test.dto.OrderRequest;
import com.kb.q3_test.modal.Order;

public interface OrderService {
    public Order createOrder(OrderRequest orderRequest);
    public Iterable<Order> getAllOrders();
    public Order getOrderById(Long id);

}
