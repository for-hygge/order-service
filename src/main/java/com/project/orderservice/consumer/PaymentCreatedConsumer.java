package com.project.orderservice.consumer;

import com.project.orderservice.dto.Order;
import com.project.orderservice.event.PaymentCreatedEvent;
import com.project.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentCreatedConsumer {
    private final OrderRepository orderRepository;

    @KafkaListener(topics = "${app.kafka.topic.payment-created}", groupId = "order-service-group")
    public void consume(PaymentCreatedEvent event) {
        log.info("Received payment-created event: {}", event);

        Order order = orderRepository.findByOrderId(event.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found, orderId = " + event.getOrderId()));

        order.setPaymentId(event.getPaymentId());
        order.setStatus("PENDING_PAYMENT");
        order.setUpdatedAt(LocalDateTime.now());

        orderRepository.save(order);
    }
}
