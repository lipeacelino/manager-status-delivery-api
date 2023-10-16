package com.example.managerstatusdelivery.controllers;

import com.example.managerstatusdelivery.dto.OrderStatusInputDTO;
import com.example.managerstatusdelivery.entities.OrderStatus;
import com.example.managerstatusdelivery.services.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statuses")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public OrderStatus changeOrderStatus(@PathVariable Long orderId, @RequestBody OrderStatusInputDTO orderStatusInputDTO) {
        return orderStatusService.changeOrderStatus(orderId, orderStatusInputDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderStatus> getOrderStatuses() {
        return orderStatusService.changeOrderStatuses();
    }

}
