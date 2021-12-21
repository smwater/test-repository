package com.cookandroid.restaurantdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Display;
import android.widget.ExpandableListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Display newDisplay = getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();

        ArrayList<myGroup> DataList = new ArrayList<myGroup>();
        listView = findViewById(R.id.diaryList);
        myGroup temp = new myGroup("소문난 해물 칼국수", "원주시 단계동", "033-766-8810");
        temp.child.add(1, "돈까스");
        temp.child.add(2, "백쌤");
        temp.child.add("해물칼국수");
        temp.child.add("보쌈");
        DataList.add(temp);
        temp = new myGroup("스테이크 팩토리", "원주시 무실동", "033-743-0045");
        temp.child.add("까르보나라");
        DataList.add(temp);
        temp = new myGroup("흥업식당", "원주시 흥업면", "033-762-9177");
        temp.child.add("제육볶음");
        DataList.add(temp);

        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), R.layout.restaurant_list, R.layout.diary_list, DataList);
        listView.setAdapter(adapter);
    }
}