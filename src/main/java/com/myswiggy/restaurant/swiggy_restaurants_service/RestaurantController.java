package com.myswiggy.restaurant.swiggy_restaurants_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
@Autowired
   RestaurantService restaurantService;
    @GetMapping("/restaurants")
    List<RestaurantPojo> getRestaurants(){
        return restaurantService.getRestaurants();
    }

    @PostMapping("/restaurants")
    RestaurantPojo registerRestaurant(@RequestBody RestaurantPojo restaurantPojo){
        return restaurantService.registerRestaurant(restaurantPojo);
    }
}
