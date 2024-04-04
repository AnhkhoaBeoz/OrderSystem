package com.kb.q3_test.service.serviceImpl;

import com.kb.q3_test.dto.OrderRequest;
import com.kb.q3_test.modal.Order;
import com.kb.q3_test.modal.PaymentMethod;
import com.kb.q3_test.modal.Product;
import com.kb.q3_test.modal.User;
import com.kb.q3_test.reposiroty.OrderRepository;
import com.kb.q3_test.reposiroty.PaymentMethodRepository;
import com.kb.q3_test.reposiroty.ProductRepository;
import com.kb.q3_test.reposiroty.UserRepository;
import com.kb.q3_test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    private PaymentMethodRepository paymentMethodRepository;
    private UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order createOrder(OrderRequest orderRequest) {
        User user = userRepository.findById(orderRequest.getUserId()).orElse(null);
        Product product = productRepository.findById(orderRequest.getProductId()).orElse(null);

        if (user == null || product == null) {
            // Xử lý khi không tìm thấy người dùng hoặc sản phẩm
            return null;
        }

        Order order = new Order();
        order.setUser(user);
        order.setShippingAddress(orderRequest.getShippingAddress());
        order.setShippingMethod(orderRequest.getShippingMethod());
        order.setPaymentMethod(paymentMethodRepository.findByName(orderRequest.getPaymentMethod()));
        order.setProducts(Collections.singletonList(product)); // Gán sản phẩm cho đơn hàng

        order.setCreatedAt(new Date());
        order.setUpdatedAt(new Date());
        order.setOrderStatus("PLACED");


        return orderRepository.save(order);
    }

    @Override
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
