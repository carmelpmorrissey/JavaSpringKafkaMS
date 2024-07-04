package com.example.persistenceservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="stockorder")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    int orderId;

    @Column(name = "order_name")
    String orderName;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "price")
    double price;
}
