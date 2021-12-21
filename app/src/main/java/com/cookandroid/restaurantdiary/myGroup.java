package com.cookandroid.restaurantdiary;

import java.util.ArrayList;

public class myGroup {
    public ArrayList<String> child;
    public String restaurantName, address, tel;
    myGroup(String restaurantName, String address, String tel){
        this.restaurantName = restaurantName;
        this.address = address;
        this.tel = tel;
        child = new ArrayList<String>();
    }
}
