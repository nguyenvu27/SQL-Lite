package com.example.admin88.thiandroid_mob204;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin88.thiandroid_mob204.Sqlite.SanPhamDAO;
import com.example.admin88.thiandroid_mob204.adapter.Adapter_sanpham;
import com.example.admin88.thiandroid_mob204.model.SanPham;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<SanPham> sanPhams;
    private SanPham sanPham;
    private SanPhamDAO sanPhamDAO;
    private Adapter_sanpham adapter_sanpham;
    private EditText ed_masp, ed_tensp,ed_id;
    private ListView lv_danhsach;
    private Button btn_them,btn_update,btn_delete;
    private OndeleteItem ondeleteItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sanPhamDAO = new SanPhamDAO(this);
        ed_id = findViewById(R.id.ed_id);
        ed_masp = findViewById(R.id.ed_masp);
        ed_tensp = findViewById(R.id.ed_tensp);
        lv_danhsach = findViewById(R.id.lv_danhsach);
        btn_delete = findViewById(R.id.btn_delete);
        btn_them = findViewById(R.id.btn_them);
        btn_update = findViewById(R.id.btn_update);
        sanPhams = sanPhamDAO.getAlldata();
        adapter_sanpham = new Adapter_sanpham(this, R.layout.item_listview, sanPhams);
        lv_danhsach.setAdapter(adapter_sanpham);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sanPham = new SanPham();
                sanPham.setId(Integer.parseInt(ed_id.getText().toString()));
                sanPham.setmMaSP(ed_masp.getText().toString());
                sanPham.setmTenSp(ed_tensp.getText().toString());
                sanPhamDAO.update(sanPham);
                btn_them.setEnabled(true);
                btn_update.setEnabled(false);
                clearfrom();
                updatedata();
            }
        });


        lv_danhsach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                btn_them.setEnabled(false);
                btn_delete.setEnabled(true);
                btn_update.setEnabled(true);
                sanPham = sanPhams.get(position);
                ed_id.setText(sanPham.getId()+"");
                ed_masp.setText(sanPham.getmMaSP());
                ed_tensp.setText(sanPham.getmTenSp());

                btn_delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeItem(position);
                        updatedata();
                        clearfrom();
                        btn_them.setEnabled(true);
                        btn_delete.setEnabled(false);
                        btn_update.setEnabled(false);
                    }
                });
            }
        });
    }



    public void btn_them(View view) {
        String masp = ed_masp.getText().toString();
        String tensp = ed_tensp.getText().toString();
        if (masp.equals("") && tensp.equals("")) {
            Toast.makeText(this, "Nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
        } else {
            sanPhamDAO.insert(new SanPham(masp, tensp));
            updatedata();
            clearfrom();
            btn_delete.setEnabled(false);
            btn_update.setEnabled(false);
            Toast.makeText(this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_update(View view) {

    }


    public void removeItem(int position){
        sanPham = new SanPham();
        sanPham = sanPhams.get(position);
        sanPhamDAO.delete(sanPham);
    }
    public void updatedata() {
        sanPhams.clear();
        sanPhams.addAll(sanPhamDAO.getAlldata());
        adapter_sanpham.notifyDataSetChanged();
    }

    public void clearfrom() {
        ed_tensp.setText("");
        ed_masp.setText("");
    }
}
