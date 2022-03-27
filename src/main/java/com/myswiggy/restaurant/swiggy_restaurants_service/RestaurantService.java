package com.myswiggy.restaurant.swiggy_restaurants_service;

import java.util.List;

public interface RestaurantService {
    List<RestaurantPojo> getRestaurants();

    RestaurantPojo registerRestaurant(RestaurantPojo restaurantPojo);
}
