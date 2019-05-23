package com.example.admin88.thiandroid_mob204.model;

public class SanPham {
    private int id;
    private String mMaSP,mTenSp;

    public SanPham(String mMaSP, String mTenSp) {
        this.mMaSP = mMaSP;
        this.mTenSp = mTenSp;
    }

    public SanPham(int id, String mMaSP, String mTenSp) {
        this.id = id;
        this.mMaSP = mMaSP;
        this.mTenSp = mTenSp;
    }

    public SanPham() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmMaSP() {
        return mMaSP;
    }

    public void setmMaSP(String mMaSP) {
        this.mMaSP = mMaSP;
    }

    public String getmTenSp() {
        return mTenSp;
    }

    public void setmTenSp(String mTenSp) {
        this.mTenSp = mTenSp;
    }
}
