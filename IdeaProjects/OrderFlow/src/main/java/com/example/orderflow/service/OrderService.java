package com.example.orderflow.service;

import com.example.orderflow.dto.*;
import com.example.orderflow.model.*;
import com.example.orderflow.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository,
                        FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.foodRepository = foodRepository;
    }

    // 🔥 SAVE ORDER
    public Order saveOrder(Order order) {

        User user = userRepository
                .findById(order.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        order.setUser(user);

        if (order.getItems() != null) {
            for (OrderItem item : order.getItems()) {

                FoodItem food = foodRepository
                        .findById(item.getFood().getFoodId())
                        .orElseThrow(() -> new RuntimeException("Food not found"));

                item.setFood(food);
                item.setOrder(order);
            }
        }

        return orderRepository.save(order);
    }

    // 🔥 CONVERT ENTITY → DTO
    private OrderResponseDTO convertToDTO(Order order) {

        User user = order.getUser();

        UserDTO userDTO = new UserDTO(
                user.getUserId(),
                user.getName(),
                user.getEmail()   // ❌ password removed
        );

        return new OrderResponseDTO(
                order.getOrderId(),
                order.getTotalPrice(),
                order.getStatus(),
                userDTO
        );
    }

    // 🔥 GET ALL ORDERS (DTO)
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }


    public Order updatePaymentStatus(Long orderId, String status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setPaymentStatus(status);

        return orderRepository.save(order);
    }
}