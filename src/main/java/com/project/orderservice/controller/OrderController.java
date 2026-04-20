package com.project.orderservice.controller;

import com.project.orderservice.dto.request.CancelOrderRequest;
import com.project.orderservice.dto.request.CreateOrderRequest;
import com.project.orderservice.dto.response.OrderDetailResponse;
import com.project.orderservice.dto.response.OrderPaymentResponse;
import com.project.orderservice.dto.response.OrderResponse;
import com.project.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getOrders(@RequestParam Long userId) {
        return orderService.getOrders(userId);
    }

    @GetMapping("/{orderId}")
    public OrderDetailResponse getOrderById(@PathVariable String orderId) {
        return orderService.getOrderById(orderId);
    }

    @GetMapping("/{orderId}/payment")
    public OrderPaymentResponse getOrderPayment(@PathVariable String orderId) {
        return orderService.getOrderPayment(orderId);
    }

    @PostMapping
    public OrderResponse createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @PostMapping("/{orderId}/cancel")
    public OrderResponse cancelOrder(@PathVariable String orderId, @Valid @RequestBody CancelOrderRequest request) {
        return orderService.cancelOrder(orderId, request);
    }
}
