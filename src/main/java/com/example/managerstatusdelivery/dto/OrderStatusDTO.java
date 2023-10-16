package com.example.managerstatusdelivery.dto;

import com.example.managerstatusdelivery.enumarators.Status;

public record OrderStatusDTO(
        Long orderId,
        Status status
) {
}
