package com.example.persistenceservice.controller;

import com.example.persistenceservice.entity.Order;
import com.example.persistenceservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        return new ResponseEntity<>(allOrders, HttpStatus.OK);
    }
}
