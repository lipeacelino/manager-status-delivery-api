package com.example.managerstatusdelivery.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderCreatedConfig {

    @Value("${rabbitmq.order.created.exchange}")
    private String exchange;

    @Value("${rabbitmq.order.created.exchange-dlx}")
    private String exchangeDlx;

    @Value("${rabbitmq.order.created.queue}")
    private String queue;

    @Value("${rabbitmq.order.created.queue-dlq}")
    private String queueDlq;

    @Value("order.*") //Aqui é possível ver na prática a diferença no uso de uma topic exchange
    private String bindingKey;

    @Bean
    public TopicExchange topicExchange() {
        return ExchangeBuilder.topicExchange(exchange).durable(false).autoDelete().build();
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.nonDurable(queue).deadLetterExchange(exchangeDlx).build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(topicExchange()).with(bindingKey);
    }

    @Bean
    public TopicExchange topicExchangeDlx() {
        return ExchangeBuilder.topicExchange(exchangeDlx).durable(false).autoDelete().build();
    }

    @Bean
    public Queue queueDlq() {
        return QueueBuilder.nonDurable(queueDlq).build();
    }

    @Bean
    public Binding bindingDlx() {
        return BindingBuilder.bind(queueDlq()).to(topicExchangeDlx()).with(bindingKey);
    }

}