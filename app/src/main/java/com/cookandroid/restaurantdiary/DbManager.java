package com.cookandroid.restaurantdiary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbManager extends SQLiteOpenHelper {
    private final String dbName = "temp";
    private final String tableName_diary = "diary";
    private final String tableName_shop = "shop";
    private final String tableName_record = "record";
    private final String tableName_menu = "menu";

    public DbManager(Context context) { super(context, "temp", null, 1);}

    @Override
    public void onCreate(SQLiteDatabase sampleDB) {     //클래스 생성되면서 동시에 실행됨 - 초기에 클래스 만들면서 create문으로 테이블생성
        sampleDB.execSQL("PRAGMA FOREIGN_KEYS = 1;");
        sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName_shop + "" +
                "(shop_id INTEGER PRIMARY KEY AUTOINCREMENT, shop_name VARCHAR(20) , shop_phone VARCHAR(20), shop_address VARCHAR(20) )");
        sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName_menu + "" +
                "(menu_id INTEGER PRIMARY KEY AUTOINCREMENT, menu_name VARCHAR(20), menu_price INTEGER, Menu_picture BLOB, flag INTEGER )");
        sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName_record + "" +
                "(record_id INTEGER PRIMARY KEY AUTOINCREMENT, shop_id INTEGER, menu_id INTEGER , record_text VARCHAR(100), record_friend VARCHAR(20), record_rate INTEGER, etc_pic1 BLOB, etc_pic2 BLOB, etc_pic3 BLOB, FOREIGN KEY(shop_id) REFERENCES shop(shop_id), FOREIGN KEY(menu_id) REFERENCES menu(menu_id)  )");
        sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " + tableName_diary + "" +
                "(diary_id INTEGER PRIMARY KEY AUTOINCREMENT, shop_id INTEGER, record_id INTEGER , FOREIGN KEY(shop_id) REFERENCES shop(shop_id) , FOREIGN KEY(record_id) REFERENCES record(record_id) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { // 버전 업데이트 일단은 공백

    }

    public Cursor getData(String query){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        return cursor;
    }
}
