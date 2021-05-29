package com.example.presensi.API;

import com.example.presensi.Model.ResponseEmployee;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("employee/")
    Call<ResponseEmployee> getEmployee();
}
