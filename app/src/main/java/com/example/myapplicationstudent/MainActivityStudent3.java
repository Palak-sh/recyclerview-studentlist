package com.example.myapplicationstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivityStudent3 extends AppCompatActivity {
    @BindView(R.id.imageView2)
    ImageView img1;
    @BindView(R.id.textView)
    TextView tv1;
    @BindView(R.id.textView2)
    TextView tv2;
    @BindView(R.id.textView3)
    TextView tv3;
    @BindView(R.id.textView4)
    TextView tv4;
    @BindView(R.id.textView6)
    TextView tv6;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student3);
        ButterKnife.bind(this);
        StudentModel temp = (StudentModel)getIntent().getSerializableExtra("StudentModel");

        tv1.setText(temp.name);
        tv2.setText(temp.num);
        tv3.setText(temp.email);
        tv4.setText(temp.zipcode);
        tv6.setText(temp.about);




    }
}