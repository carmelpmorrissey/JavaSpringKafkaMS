package com.example.persistenceservice.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEvent {
    private String message;
    private String status;
    private Order order;
}
