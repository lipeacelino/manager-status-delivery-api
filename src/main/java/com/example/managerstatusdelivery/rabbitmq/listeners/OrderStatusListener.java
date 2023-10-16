package com.example.managerstatusdelivery.rabbitmq.listeners;

import com.example.managerstatusdelivery.dto.OrderStatusDTO;
import com.example.managerstatusdelivery.entities.OrderStatus;
import com.example.managerstatusdelivery.repositories.OrderStatusRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusListener {

    @Autowired
    private OrderStatusRepository orderStatusRepository;

    @RabbitListener(queues = "${rabbitmq.order.created.queue}")
    private void orderListener(OrderStatusDTO orderStatusDTO) {
        OrderStatus orderStatus = OrderStatus.builder()
                .orderId(orderStatusDTO.orderId())
                .status(orderStatusDTO.status())
                .build();
        orderStatusRepository.save(orderStatus);
    }

}
