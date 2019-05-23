package com.example.admin88.thiandroid_mob204.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin88.thiandroid_mob204.R;
import com.example.admin88.thiandroid_mob204.model.SanPham;

import java.util.List;

public class Adapter_sanpham extends ArrayAdapter<SanPham> {
    private List<SanPham> sanPhams;
    private LayoutInflater inflater;
    public Adapter_sanpham(@NonNull Context context, int resource, @NonNull List<SanPham> objects) {
        super(context, resource, objects);
        this.sanPhams = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHodel hodel;
        if (convertView == null){
            hodel = new ViewHodel();
            convertView = inflater.inflate(R.layout.item_listview,parent,false);
            hodel.tv_id = convertView.findViewById(R.id.tv_id);
            hodel.tv_masp = convertView.findViewById(R.id.tv_masp);
            hodel.tv_tensp = convertView.findViewById(R.id.tv_tensp);
            convertView.setTag(hodel);
        }else {
            hodel = (ViewHodel) convertView.getTag();
        }
        SanPham sanPham = sanPhams.get(position);
        hodel.tv_id.setText(sanPham.getId()+"");
        hodel.tv_masp.setText(sanPham.getmMaSP());
        hodel.tv_tensp.setText(sanPham.getmTenSp());
        return convertView;
    }

    public class ViewHodel{
        public TextView tv_id,tv_masp,tv_tensp;
    }
}
