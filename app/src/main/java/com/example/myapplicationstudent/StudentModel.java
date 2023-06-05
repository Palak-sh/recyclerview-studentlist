package com.example.myapplicationstudent;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class StudentModel implements Serializable {


    @SerializedName("img")
    public int img;
    @SerializedName("name")
    public String name;
    @SerializedName("num")
    public String num;
    @SerializedName("email")
    public String email;
    @SerializedName("zipcode")
    public String zipcode;
    @SerializedName("about")
    public String about;
    @SerializedName("title")
    public String title;
    @SerializedName("userId")
    public String userId;
    @SerializedName("id")
    public String id;
    @SerializedName("completed")
    public String completed;
    @SerializedName("hobby")
    public String hobby;




}
