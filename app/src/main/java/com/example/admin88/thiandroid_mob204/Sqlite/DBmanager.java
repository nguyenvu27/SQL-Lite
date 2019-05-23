package com.example.admin88.thiandroid_mob204.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmanager extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QL_SAN_PHAM";
    public static final String TABLE_NAME = "SAN_PHAM";
    public static final String ID = "ID";
    public static final String MASP = "MASP";
    public static final String TENSP = "TENSP";
    public DBmanager(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sanpham = "create table SAN_PHAM (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "MASP TEXT," +
                "TENSP TEXT)";
        db.execSQL(sanpham);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
}
