package com.cookandroid.restaurantdiary;

public class RestaurantListData {
    private String restName, address, tel;

    public RestaurantListData(String restName, String address, String tel) {
        this.restName = restName;
        this.address = address;
        this.tel = tel;
    }

    String getRestName() {
        return this.restName;
    }

    String getAddress() {
        return this.address;
    }

    String getTel() {
        return this.tel;
    }
}
