package com.myswiggy.restaurant.swiggy_restaurants_service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService{
    Logger logger= LoggerFactory.getLogger(RestaurantServiceImpl.class);
    @Autowired
    RestaurantRepo restaurantRepo;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<RestaurantPojo> getRestaurants() {
        return restaurantRepo.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RestaurantPojo registerRestaurant(RestaurantPojo restaurantPojo) {
        logger.info(restaurantPojo.toString());
        Restaurant  restaurant=  convertToEntity(restaurantPojo);
        logger.info(restaurant.toString());
         restaurant=restaurantRepo.save(restaurant);
        logger.info(restaurant.toString());
        return convertToDto(restaurant);
    }

    private RestaurantPojo convertToDto(Restaurant restaurant) {
        RestaurantPojo restaurantPojo = modelMapper.map(restaurant, RestaurantPojo.class);;
        return restaurantPojo;
    }

    private Restaurant convertToEntity(RestaurantPojo restaurantPojo) {
        Restaurant restaurant = modelMapper.map(restaurantPojo, Restaurant.class);;
        return restaurant;
    }
}
