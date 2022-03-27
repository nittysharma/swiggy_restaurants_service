package com.myswiggy.restaurant.swiggy_restaurants_service;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
public class RestaurantPojo {
    private UUID id;
    private String alias;
    private String name;
    private String address;
}
