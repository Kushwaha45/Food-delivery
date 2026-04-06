package com.example.orderflow.dto;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {

    private Long orderId;
    private double totalPrice;
    private String status;
    private UserDTO user;
}