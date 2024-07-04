package com.example.stockservice.kafka;

import com.example.persistenceservice.entity.OrderEvent;
import com.example.persistenceservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private OrderService orderService;

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent event) {
        LOGGER.info(String.format("Order event received in stock service => %s", event.toString()));

        // save the order event data into the database
        orderService.saveOrUpdateOrder(event.getOrder());

    }
}
