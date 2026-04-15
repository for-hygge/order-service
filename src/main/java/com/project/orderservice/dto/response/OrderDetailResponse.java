package com.project.orderservice.dto.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderDetailResponse {
    private String orderId;
    private Long userId;
    private String status;
    private BigDecimal totalAmount;
    private List<ItemResponse> items;
    private ShippingAddressResponse shippingAddress;
}
