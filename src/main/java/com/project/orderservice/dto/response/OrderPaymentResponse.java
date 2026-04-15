package com.project.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderPaymentResponse {
    private String orderId;
    private String paymentId;
    private String paymentStatus;
    private String paymentMethod;
    private BigDecimal amount;
}
