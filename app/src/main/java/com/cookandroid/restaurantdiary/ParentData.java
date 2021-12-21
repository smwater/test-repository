package com.cookandroid.restaurantdiary;

import java.util.Vector;

public class ParentData {   // restaurant_list에 대한 class
    private String restName, address, tel;

    public Vector<Child> child;

    public ParentData(String restName, String address, String tel) {
        this.restName = restName;
        this.address = address;
        this.tel = tel;
        child = new Vector<>();
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
