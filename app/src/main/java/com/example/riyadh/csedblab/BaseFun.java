package com.example.riyadh.csedblab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by riyadh on 01-Jul-18.
 */

public class BaseFun extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db";
    private static final String TABLE_NAME = "tab";
    private static final String col_reg = "reg";
    private static final String col_course = "course";
    private static final String col_des = "des";
    private static final String col_title = "title";


    BaseFun(Context c) {
        super(c, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase mydb) {
        String s = "CREATE TABLE " + TABLE_NAME + "(" + col_reg + " INT PRIMARY KEY," + col_course + " TEXT," + col_title + " TEXT," + col_des + " TEXT)";
        mydb.execSQL(s);
        Log.e("dbstat", "database created successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    // adding data to db

    public boolean addData(String reg, String course, String title, String des) {
        SQLiteDatabase sqdb = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_reg, reg);
        cv.put(col_course, course);
        cv.put(col_title, title);
        cv.put(col_des, des);
        long flag=  sqdb.insert(TABLE_NAME, null, cv);
        if(flag==-1) return false;
        else return true;
    }

    String[] getAll() {
        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM " + TABLE_NAME;

        Cursor c = sq.rawQuery(q, null);

        String[] recvied_data = new String[c.getCount()];

        int i = 0;
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            recvied_data[i++] = c.getString(c.getColumnIndex(col_reg)) + " | Course: " + c.getString(c.getColumnIndex(col_course)) + " | Title: " +
                    c.getString(c.getColumnIndex(col_title));
        }

        return recvied_data;
    }

    Cursor getAllByCursor() {
        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM " + TABLE_NAME;

        Cursor c = sq.rawQuery(q, null);

        return c;

    }

    int getByReg(int reg) {
        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "select * from " + TABLE_NAME + " where " + col_reg + " =" + reg;
        Cursor c = sq.rawQuery(q, null);
        int res = c.getColumnCount();

        return  res;

    }

    void removeByReg(int reg) {
        SQLiteDatabase sq = this.getWritableDatabase();
        String q = "delete from "+TABLE_NAME+" where "+col_reg+" ="+reg;
        sq.execSQL(q);

    }

    void update(String reg, String title, String description){
        ContentValues cv = new ContentValues();

    }


}
