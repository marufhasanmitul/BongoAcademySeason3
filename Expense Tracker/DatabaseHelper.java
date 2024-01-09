package com.maruftech.expencetrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "digital_moneybag", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table expence(id INTEGER primary key autoincrement,amount DOUBLE,reasons TEXT,time DOUBLE)");
        db.execSQL("create table income(id INTEGER primary key autoincrement,amount DOUBLE,reasons TEXT,time DOUBLE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists expence");
        db.execSQL("drop table if exists income");
    }

    public void addExpence(double amount,String reason){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("reasons",reason);
        contentValues.put("time",System.currentTimeMillis());


        db.insert("expence",null,contentValues);
    }


    public void addIncome(double amount,String reason){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("amount",amount);
        contentValues.put("reasons",reason);
        contentValues.put("time",System.currentTimeMillis());


        db.insert("income",null,contentValues);
    }

    //======================================================
    public double calculateTotalExpense(){
        double totalExpense=0;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from expence",null);
        if(cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                double expense=cursor.getDouble(1);
                totalExpense=totalExpense+expense;
            }
        }

        return totalExpense;
    }

    //======================================================

    //======================================================
    public double calculateTotalIncome(){
        double totalIncome=0;

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from income",null);
        if(cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){
                double expense=cursor.getDouble(1);
                totalIncome=totalIncome+expense;
            }
        }

        return totalIncome;
    }

    //======================================================

    public Cursor showAllData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from expence",null);
        return cursor;
    }

    //======================================================

    public Cursor showAllInCome(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("select * from income",null);
        return cursor;
    }

    //========================================================
    public void deleteById(String position){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("delete from expence where id like "+position);
    }


}
