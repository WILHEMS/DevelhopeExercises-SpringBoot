package com.example.springboot.component;

import org.springframework.stereotype.Component;

@Component
public class RestaurantConfig {
    private double miniPrice = 5.5;
    private double todayDiscount = 1.5;

    public RestaurantConfig() {
    }

    public double getMiniPrice() {
        return miniPrice;
    }

    public void setMiniPrice(double miniPrice) {
        this.miniPrice = miniPrice;
    }

    public double getTodayDiscount() {
        return todayDiscount;
    }

    public void setTodayDiscount(double todayDiscount) {
        this.todayDiscount = todayDiscount;
    }
}
