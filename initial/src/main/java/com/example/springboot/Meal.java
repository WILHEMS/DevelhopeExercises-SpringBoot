package com.example.springboot;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.List;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private Double price;
//    private Ingredient ingredient;
    private  boolean isSummerMeal;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    public Meal(String name, String description, Double price, boolean isSummerMeal) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.isSummerMeal = isSummerMeal;
    }

    public Meal() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public boolean isSummerMeal() {
        return isSummerMeal;
    }

    public void setSummerMeal(boolean summerMeal) {
        isSummerMeal = summerMeal;
    }
}
