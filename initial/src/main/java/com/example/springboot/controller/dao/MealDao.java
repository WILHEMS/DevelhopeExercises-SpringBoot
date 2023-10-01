package com.example.springboot.controller.dao;

import com.example.springboot.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealDao extends JpaRepository<Meal, Long> {
    List<Meal> findByName(String name);
    List<Meal> findByPriceGreaterThan(double price);
}
