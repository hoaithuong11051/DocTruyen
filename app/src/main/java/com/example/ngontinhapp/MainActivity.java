package com.example.ngontinhapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.ngontinhapp.adapter.TruyenTranhAdapter;
import com.example.ngontinhapp.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
GridView gdvDSTruyen;
TruyenTranhAdapter adapter;
ArrayList<TruyenTranh> truyenTranhArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhxa();
        sepUp();
        setClick();
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://st.nettruyen.com/data/comics/154/ba-dao-tieu-thuc-xin-treu-choc-vua-thoi.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Danh môn chí ái","chap24.2","https://chiasekienthuc365.com/wp-content/uploads/2019/08/Untitled-1.jpg"));


        adapter  = new TruyenTranhAdapter(this,0,truyenTranhArrayList);

    }
    private void anhxa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
    }
    private void sepUp(){
        gdvDSTruyen.setAdapter(adapter);
    }
    private void setClick(){}
}
