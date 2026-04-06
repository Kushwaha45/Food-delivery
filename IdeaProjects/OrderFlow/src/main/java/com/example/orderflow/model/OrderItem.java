package com.example.orderflow.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    private int quantity;

    // many items → one food
    @ManyToOne
    @JoinColumn(name = "food_id")
    private FoodItem food;

    // 🔥 FIX: prevent infinite JSON loop
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}