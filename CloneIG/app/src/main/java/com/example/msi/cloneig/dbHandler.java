package com.example.msi.cloneig;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by MSI on 23/10/2018.
 */

public class dbHandler extends SQLiteOpenHelper{

    //nama database yang dibuat
    private static final String DB_NAME = "User.db";
    //nama tabel yang dibuat
    private static final String TABLE_NAME = "user";

    public dbHandler(Context context) {
        super(context,DB_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table user( email text, nama text, username text primary key, password text);";
        Log.d("Data" , "onCreate : "+sql);
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
    }

//    public void addRecord(userModel userModel){
//        SQLiteDatabase db  = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(KEY_EMAIL, userModel.getEmail());
//        values.put(KEY_NAME, userModel.getNama());
//        values.put(KEY_USERNAME, userModel.getUsername());
//        values.put(KEY_PASSWORD, userModel.getPassword());
//
//
//        db.insert(TABLE_NAME, null, values);
//        db.close();
//    }

    public boolean cekLogin(String nama, String pwd){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from user where username=? and password=?", new String[]{nama,pwd});

        if(cursor.getCount()>0){
            return true;
        }else return false;
    }

}
