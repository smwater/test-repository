package com.cookandroid.restaurantdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;
    private ExpandableListView parentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        Vector<ParentData> data = new Vector<>();
        parentListView = (ExpandableListView)findViewById(R.id.parentListView);

        ParentData parentData1 = new ParentData("소문난 해물칼국수", "원주시 단계동", "033-766-8810");
        parentData1.child.add(new Child("9/5", "돈까스", "백쌤"));
        parentData1.child.add(new Child("7/26", "해물칼국수", "혜림"));
        parentData1.child.add(new Child("7/2", "보쌈", "규배"));
        data.add(parentData1);
        ParentData parentData2 = new ParentData("스테이크 팩토리", "원주시 무실동", "033-743-0045");
        parentData2.child.add(new Child("8/21", "까르보나라", "진우, 희찬"));
        data.add(parentData2);
        ParentData parentData3 = new ParentData("흥업식당", "원주시 흥업면", "033-762-9177");
        parentData3.child.add(new Child("8/7", "제육볶음", "재왕, 지수"));
        data.add(parentData3);

        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), data);
        parentListView.setAdapter(adapter);
    }
}