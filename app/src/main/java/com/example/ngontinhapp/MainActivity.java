package com.example.ngontinhapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ngontinhapp.adapter.TruyenTranhAdapter;
import com.example.ngontinhapp.object.TruyenTranh;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TruyenTranhAdapter adapter;
    EditText edtTimKiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new TruyenTranhAdapter(this);
        anhxa();
        sepUp();
        getData();

    }

    private void anhxa() {
        recyclerView = findViewById(R.id.recyclerView);
        edtTimKiem = findViewById(R.id.edtTimKiem);


    }

    private void sepUp() {
        recyclerView.setAdapter(adapter);
    }

    private void getData() {
        String url = "https://truyentranhandroid.000webhostapp.com/danhsachtruyen.php";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<TruyenTranh> truyenTranhs = new ArrayList<>();
                try {
                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.getJSONObject(i);
                        String tenTruyen = object.getString("tenTruyen");
                        String chapTruyen = object.getString("chapTruyen");
                        String anhTruyen = object.getString("anhTruyen");
                        TruyenTranh truyenTranh = new TruyenTranh(tenTruyen, chapTruyen, anhTruyen);
                        truyenTranhs.add(truyenTranh);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                adapter.setData(truyenTranhs);
                setClick(truyenTranhs);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(this).add(stringRequest);
    }

    private void setClick(final List<TruyenTranh> truyenTranhs) {
        edtTimKiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String s = edtTimKiem.getText().toString().trim().toLowerCase();
                if (s.isEmpty()) {
                    adapter.setData(truyenTranhs);
                } else {
                    List<TruyenTranh> truyenTranhList = new ArrayList<>();
                    for (int i = 0; i < truyenTranhs.size(); i++) {
                        if (truyenTranhs.get(i).getTenTruyen().toLowerCase().startsWith(s.toLowerCase())) {
                            truyenTranhList.add(truyenTranhs.get(i));
                        }
                    }
                    adapter.setData(truyenTranhList);
                }
            }
        });
    }
}
