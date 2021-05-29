package com.example.presensi.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.presensi.API.ApiClient;
import com.example.presensi.API.ApiInterface;
import com.example.presensi.Adapter.EmployeeAdapter;
import com.example.presensi.Model.EmployeeModel;
import com.example.presensi.Model.ResponseEmployee;
import com.example.presensi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvEmployee;
    private RecyclerView.Adapter adEmployee;
    private RecyclerView.LayoutManager lmEmployee;

    private List<EmployeeModel> listEmployee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEmployee = findViewById(R.id.rv_employee);
        lmEmployee = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvEmployee.setLayoutManager(lmEmployee);
        retriveData();
    }

    public void retriveData(){
        ApiInterface ai = ApiClient.koneksi().create(ApiInterface.class);
        Call<ResponseEmployee> showEmployee = ai.getEmployee();

        showEmployee.enqueue(new Callback<ResponseEmployee>() {
            @Override
            public void onResponse(Call<ResponseEmployee> call, Response<ResponseEmployee> response) {
                String message = response.message();

                Toast.makeText(MainActivity.this, "Message: "+message, Toast.LENGTH_SHORT).show();

                listEmployee = response.body().getEmployee();

                adEmployee = new EmployeeAdapter(MainActivity.this, listEmployee);
                rvEmployee.setAdapter(adEmployee);
                adEmployee.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ResponseEmployee> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal Menghubungi Server :"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}