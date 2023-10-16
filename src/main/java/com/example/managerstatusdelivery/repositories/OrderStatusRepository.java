package com.example.managerstatusdelivery.repositories;

import com.example.managerstatusdelivery.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    Optional<OrderStatus> findByOrderId(Long orderId);

}
