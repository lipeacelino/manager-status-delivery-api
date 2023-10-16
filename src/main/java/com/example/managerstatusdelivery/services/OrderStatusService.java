package com.example.managerstatusdelivery.services;

import com.example.managerstatusdelivery.dto.OrderStatusInputDTO;
import com.example.managerstatusdelivery.entities.OrderStatus;
import com.example.managerstatusdelivery.rabbitmq.publishers.StatusUpdatedPublisher;
import com.example.managerstatusdelivery.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusService {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @Autowired
    private StatusUpdatedPublisher statusUpdatedPublisher;

    public OrderStatus changeOrderStatus(Long orderId, OrderStatusInputDTO orderStatusInputDTO) {
        OrderStatus orderStatus = orderStatusRepository.findByOrderId(orderId).orElseThrow(() -> new RuntimeException("OrderStatus not found"));
        orderStatus.setStatus(orderStatusInputDTO.status());
        OrderStatus orderUpdated = orderStatusRepository.save(orderStatus);
        statusUpdatedPublisher.send(orderUpdated);
        return orderUpdated;
    }

    public List<OrderStatus> changeOrderStatuses() {
        return orderStatusRepository.findAll();
    }
}
