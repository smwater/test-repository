package com.cookandroid.restaurantdiary;

public class DiaryListData {
    private String date, menu, friend;

    public DiaryListData(String date, String menu, String friend) {
        this.date = date;
        this.menu = menu;
        this.friend = friend;
    }

    String getDate() {
        return this.date;
    }

    String getMenu() {
        return this.menu;
    }

    String getFriend() {
        return this.friend;
    }
}
