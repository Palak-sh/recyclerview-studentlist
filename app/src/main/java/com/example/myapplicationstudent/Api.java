package com.example.myapplicationstudent;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {


    @GET("todos")
    Call<ArrayList<StudentModel>> getstudents();
}
