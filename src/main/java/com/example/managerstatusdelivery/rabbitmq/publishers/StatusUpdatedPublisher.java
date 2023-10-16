package com.example.managerstatusdelivery.rabbitmq.publishers;

import com.example.managerstatusdelivery.entities.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StatusUpdatedPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.order.update-status.exchange}")
    private String exchange;

    @Value("${rabbitmq.order.update-status.routing.key}")
    private String routingKey;

    public void send(OrderStatus orderStatus) {
        rabbitTemplate.convertAndSend(exchange, routingKey, orderStatus);
    }

}
