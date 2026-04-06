package com.example.orderflow.controller;

import com.example.orderflow.model.FoodItem;
import com.example.orderflow.service.FoodService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public FoodItem addFood(@RequestBody FoodItem food) {
        return foodService.saveFood(food);
    }

    @GetMapping
    public List<FoodItem> getFood() {
        return foodService.getAllFood();
    }


    // DELETE FOOD
    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);   // ✅ FIX HERE
        return "Food deleted successfully";
    }

}