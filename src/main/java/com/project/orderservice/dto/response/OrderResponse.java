package com.project.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderResponse {
    private String orderId;
    private Long userId;
    private String status;
    private BigDecimal totalAmount;
    private String paymentId;
}
