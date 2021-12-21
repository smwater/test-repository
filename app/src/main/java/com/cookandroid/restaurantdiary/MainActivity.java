package com.cookandroid.restaurantdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;
    private ExpandableListView parentListView;

    private final String dbName = "temp";
    private final String tableName_diary = "diary";
    private final String tableName_shop = "shop";
    private final String tableName_record = "record";
    private final String tableName_menu = "menu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        Vector<ParentData> data = new Vector<>();
        parentListView = (ExpandableListView)findViewById(R.id.parentListView);

        DbManager dbManager = new DbManager(getApplicationContext());

        // 아래의 주석은 테스트용으로 만들어둔 데이터입니다.
        // 해당 부분 확인하고 DB와 연동해주세요.
        // 단, 프로그램이 완전히 완성되기 전까지는 데이터를 삭제하지 말아주세요.

//        // ParentData에 내용 추가
//        ParentData parentData1 = new ParentData("소문난 해물칼국수", "원주시 단계동", "033-766-8810");
//        parentData1.child.add(new Child("9/5", "돈까스", "백쌤"));
//        parentData1.child.add(new Child("7/26", "해물칼국수", "혜림"));
//        parentData1.child.add(new Child("7/2", "보쌈", "규배"));
//        data.add(parentData1);  // data에 추가하지 않으면 화면에 표시되지 않음
//
//        ParentData parentData2 = new ParentData("스테이크 팩토리", "원주시 무실동", "033-743-0045");
//        parentData2.child.add(new Child("8/21", "까르보나라", "진우, 희찬"));
//        data.add(parentData2);
//
//        ParentData parentData3 = new ParentData("흥업식당", "원주시 흥업면", "033-762-9177");
//        parentData3.child.add(new Child("8/7", "제육볶음", "재왕, 지수"));
//        data.add(parentData3);
        ArrayList<ParentData> DataList = new ArrayList<ParentData>();
        parentListView = findViewById(R.id.parentListView);
        ParentData temp;
        Cursor cursor = dbManager.getData("SELECT * FROM shop");

        while(cursor.moveToNext()){
            temp = new ParentData(cursor.getString(1), cursor.getString(3), cursor.getString(2));
            DataList.add(temp);
        }

        ExpandAdapter adapter = new ExpandAdapter(getApplicationContext(), data);
        parentListView.setAdapter(adapter); // adapter 설정 안 하면 화면에 표시되지 않음
    }
}