package com.example.persistenceservice.service;

import com.example.persistenceservice.dao.OrderRepository;
import com.example.persistenceservice.entity.Order;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public void saveOrUpdateOrder(Order order) {
        log.info("Inserting order object");
        orderRepository.save(order);
    }
    public List<Order> getAllOrders() {
        log.info("Finding order objects");
        return orderRepository.findAll();
    }
}
