package com.example.orderservice.controller;

import com.example.orderservice.kafka.OrderProducer;
import com.example.persistenceservice.entity.Order;
import com.example.persistenceservice.entity.OrderEvent;
import com.example.persistenceservice.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order) {

        //order.setOrderId(Integer.parseInt(UUID.randomUUID().toString()));

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is pending");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order placed successfully!  Reference order id: " + order.getOrderId();
    }
}
