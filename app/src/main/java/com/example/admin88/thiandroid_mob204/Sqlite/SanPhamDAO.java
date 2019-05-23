package com.example.admin88.thiandroid_mob204.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.admin88.thiandroid_mob204.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private SQLiteDatabase db;
    private SanPham sanPham;

    public SanPhamDAO(Context context){
        DBmanager dBmanager = new DBmanager(context);
        db = dBmanager.getWritableDatabase();
    }

    public long insert(SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put("MASP",sanPham.getmMaSP());
        values.put("TENSP",sanPham.getmTenSp());
        return db.insert("SAN_PHAM",null,values);
    }
    public List<SanPham> getAlldata(){
        List<SanPham> list = new ArrayList<>();
        String sql = "select * from SAN_PHAM ";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String masp = cursor.getString(cursor.getColumnIndex("MASP"));
            String tensp = cursor.getString(cursor.getColumnIndex("TENSP"));
            list.add(new SanPham(id,masp,tensp));
        }
        return list;
    }
    public int update(SanPham sanPham){
        ContentValues values = new ContentValues();
        values.put("MASP",sanPham.getmMaSP());
        values.put("TENSP",sanPham.getmTenSp());
        return db.update("SAN_PHAM",values,"ID=?",new String[]{sanPham.getId()+""});
    }
    public int delete(SanPham sanPham){
        return db.delete("SAN_PHAM","ID=?",new String[]{sanPham.getId()+""});
    }
}
