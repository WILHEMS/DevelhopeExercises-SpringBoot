package com.example.springboot.controller;

import com.example.springboot.Ingredient;
import com.example.springboot.Meal;
import com.example.springboot.component.RestaurantConfig;
import com.example.springboot.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/api/meal/")
public class MealController {
	private MealService mealService;
	private RestaurantConfig restaurantConfig;

	@Autowired
	public MealController(MealService mealService, RestaurantConfig restaurantConfig) {
		this.mealService = mealService;
		this.restaurantConfig = restaurantConfig;
	}

	@GetMapping("/restaurant-config")
	public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
		return ResponseEntity.ok(restaurantConfig);
	}
	@GetMapping("/insert-meal-test")
	public ResponseEntity<?> insertMealTest(){
		mealService.insertMealTest();
		mealService.test();
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/delete/{mealId}")
	public ResponseEntity<Long> deleteMealTest(@PathVariable Long mealId){
		mealService.deleteMealTest(mealId);
		return ResponseEntity.ok().build();
	}
	@PostMapping("/meal-many-to-one")
	public ResponseEntity<Meal> mealManyToOne(){
		Meal meal = new Meal("Chicken", "Soup", 100.0, true, true);
		Ingredient ingredient = new Ingredient("Dumpling", true,true,false,true);
		ingredient.setMeal(meal);
		meal.setIngredients(Arrays.asList(ingredient));
		mealService.addMeal(meal);
		return ResponseEntity.ok().build();
	}

//	@PostMapping
//	public ResponseEntity<?> createMeal(@RequestBody Meal meal){
//		mealService.createMeal(meal);
//		return ResponseEntity.ok().build();
//	}
//
//	@GetMapping("{mealId}")
//	public ResponseEntity<Meal> retrieveMeal(@PathVariable("mealId") long mealId) {
//		return ResponseEntity.ok(mealService.getMeal(mealId));
//	}
//	@GetMapping("{mealId}")
//	public ResponseEntity<RestaurantConfig> getRestaurantConfig(){
//		return ResponseEntity.ok(restaurantConfig);
//	}
//	@PutMapping("/put/meals")
//	public ResponseEntity<String> putMeal(@RequestBody Meal meal) {
//		try {
//			mealService.addMeal(meal);
//			return ResponseEntity.ok("Meal added!");
//		}catch (IllegalArgumentException e){
//			return ResponseEntity.badRequest().body(e.getMessage());
//		}
//
//	}
//	@DeleteMapping("/delete/meals/{mealName}")
//	public ResponseEntity<String> deleteMeal(@PathVariable String mealName) {
//		mealService.deleteMeal(mealName);
//		return ResponseEntity.ok("Meal deleted!");
//	}
//	@PostMapping("/post/replace-meal")
//	public ResponseEntity<String> postMeal(@RequestBody Meal meal){
//		this.meals.removeIf(m -> m.getName().equals(meal.getName()));
//		this.meals.add(meal);
//		return ResponseEntity.ok("Meal updated");
//	}


//	}
//	private List<Meal> chefsSpecials = Arrays.asList(
//			new Meal("Chefs Special","A me al made by the Chef", 10.00),
//			new Meal("Chefs Special One","A meal made by the Chef", 11.00),
//			new Meal("Chefs Special Two","A meal made by the Chef", 12.00),
//			new Meal("Chefs Special Three","A meal made by the Chef", 13.00),
//			new Meal("Chefs Special Four","A meal made by the Chef", 14.00),
//			new Meal("Chefs Special Five","A meal made by the Chef", 15.00),
//			new Meal("Chefs Special Six","A meal made by the Chef", 16.00)
//	);
//
//	private List<Meal> soupOfOfTheDay = Arrays.asList(
//			new Meal("Chicken Soup","A soup meal made by the Chef", 12.00),
//			new Meal("Chicken Soup","A soup meal made by the Chef", 12.00),
//			new Meal("Chicken Soup","A soup meal made by the Chef", 12.00),
//			new Meal("Chicken Soup","A soup meal made by the Chef", 12.00)
//	);

}
