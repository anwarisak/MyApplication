package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MysqlDB extends SQLiteOpenHelper {
    Context ctx;

    public MysqlDB(@Nullable Context context) {
        super(context, "cs19kdb", null, 1);
        context =ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table employee(id integer primary key autoincrement , empname text ) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table employee");

    }

    public  void saveemp(String empname ){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("empname", empname);
        db.insert("employee",null,values );

        Toast.makeText(ctx, "data is saved", Toast.LENGTH_SHORT).show();
    }
}
