package com.example.managerstatusdelivery.entities;

import com.example.managerstatusdelivery.enumarators.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "orders")
@AllArgsConstructor
public class OrderStatus {

    @Id
    @GeneratedValue
    private Long id;

    private Long orderId;

    private Status status;

}
