package com.example.orderflow.service;

import com.example.orderflow.model.FoodItem;
import com.example.orderflow.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public FoodItem saveFood(FoodItem food) {
        return foodRepository.save(food);
    }

    public List<FoodItem> getAllFood() {
        return foodRepository.findAll();
    }

    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}