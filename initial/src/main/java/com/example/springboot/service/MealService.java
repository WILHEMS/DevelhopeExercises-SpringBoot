package com.example.springboot.service;

import com.example.springboot.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.controller.dao.MealDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    //private List<Meal> meals = new ArrayList<>();
    private MealDao mealDao;
    private RestaurantConfig restaurantConfig;

    @Autowired
    public MealService(MealDao mealDao, RestaurantConfig restaurantConfig) {
        this.mealDao = mealDao;
        this.restaurantConfig = restaurantConfig;
    }
    public void insertMealTest(){
        mealDao.save(new Meal("Test Meal", "Very tasty", 4.88,true));
    }
    public void deleteMealTest(long id){
        mealDao.deleteById(id);
    }
    public void addMeal(Meal meal){
        mealDao.save(meal);
    }
    public List<Meal> getMeals(){
        return mealDao.findAll();
    }
    public void updateMeal(Meal meal){
        mealDao.save(meal);
    }
    public void test(){
        mealDao.findByName("Chicken").forEach(System.out::println);
        System.out.println();
    }
//
//    public void addMeal(Meal meal) {
//        if (meal == null) throw new IllegalArgumentException("Meal cannot be null!");
//        mealDao.addMeal(meal);
//    }
//
//    public void deleteMeal(String mealName) {
//        mealDao.deleteMeal(mealName);
//    }
//
//    public void updateMeal(Meal meal, long mealId) {
//        mealDao.updateMeal(meal);
//    }

    public void createMeal(Meal meal) {
        mealDao.save(meal);
    }
    public Meal getMeal(long mealId){
        return mealDao.findById(mealId).orElse(null);
    }
}

//    public List<Meal> getMeals(long mealId){
//        return mealDao.getMeals();
//    }
//}
