package com.example.orderflow.controller;

import com.example.orderflow.dto.OrderResponseDTO;
import com.example.orderflow.model.Order;
import com.example.orderflow.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // CREATE ORDER
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    // GET ORDERS (DTO RESPONSE)
    @GetMapping
    public List<OrderResponseDTO> getOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/{orderId}/payment")
    public Order updatePayment(@PathVariable Long orderId,
                               @RequestParam String status) {
        return orderService.updatePaymentStatus(orderId, status);
    }
}