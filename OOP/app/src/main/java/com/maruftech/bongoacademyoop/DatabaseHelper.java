package com.maruftech.bongoacademyoop;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME="my_database";
    public static final Integer VERSION=1;

    public DatabaseHelper(Context context) {
        super(context,DB_NAME, null,VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table my_table(id INTEGER primary key autoincrement,name TEXT,mobile TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists my_table");
    }

    public void insertData(String name,String mobile){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("mobile",mobile);

        database.insert("my_table",null,contentValues);
    }

}
