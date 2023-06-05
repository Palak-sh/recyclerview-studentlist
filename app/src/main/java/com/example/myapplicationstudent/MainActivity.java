package com.example.myapplicationstudent;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.car.ui.toolbar.MenuItem;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<StudentModel> arrstudents = new ArrayList<>();
    RecyclerStudentAdapter adapter;
    @BindView(R.id.btnOpenDialog)
    Button btnOpenDialog;
    @BindView(R.id.recyclerStudent)
    RecyclerView recyclerView;
    Context context;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    //LinearLayoutManager layoutManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ButterKnife.bind(this);
        context = this;
        setClickListener();

        // InsertData();

        setRecyclerVew();
       // fetchdata();
        //getstudents();
        /*try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl("https://randomuser.me/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Api api = retrofit.create(Api.class);
            Call<ArrayList<StudentModel>> call = Api.getstudents();
            call.enqueue(new Callback<ArrayList<StudentModel>>() {
                @Override
                public void onResponse(Call<ArrayList<StudentModel>> call, Response<ArrayList<StudentModel>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    ArrayList<StudentModel> arrstudents = response.body();

                    RecyclerStudentAdapter recyclerStudentAdapter = new RecyclerStudentAdapter(MainActivity.this, arrstudents);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<ArrayList<StudentModel>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            });
        }catch(Exception e) {
            System.out.println(e);
        }
    }
    private void getstudents() {
       *//* Call<ArrayList<StudentModel>> call = RetrofitClient.getInstance().getMyApi().getstudents();
        call.enqueue(new Callback<ArrayList<StudentModel>>() {

            @Override
            public void onResponse(Call<ArrayList<StudentModel>> call, Response<ArrayList<StudentModel>> response) {
                ArrayList<StudentModel> arrstudents = response.body();
                String[] students = new String[arrstudents.size()];

                for (int i = 0; i < arrstudents.size(); i++) {
                    students[i] = arrstudents.get(i).name;
                    students[i] = arrstudents.get(i).num;
                    students[i] = arrstudents.get(i).email;
                    students[i] = arrstudents.get(i).zipcode;
                    students[i] = arrstudents.get(i).about;

                }

                recyclerView.setAdapter(adapter);
            }


            @Override
            public void onFailure(Call<ArrayList<StudentModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();}
        });*//*
         */
        navigationView=findViewById(R.id.navigationmenu);
        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.bringToFront();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.nav_A ){
                    Intent intent = new Intent(MainActivity.this, MyApplicationStudent2.class);
                    startActivityForResult(intent, 2);
                } else  {
                 Intent intent  =  new Intent(MainActivity.this,MainActivity.class);
                 startActivity(intent);
                }

                return false;
            }
        });


    }



    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected((android.view.MenuItem) item)) {
            return true;
        }
        return super.onOptionsItemSelected((android.view.MenuItem) item);
    }


//    private void fetchdata(){
//         RetrofitClient.getRetrofitClient().getstudents().enqueue(new Callback<ArrayList<StudentModel>>() {
//             @Override
//             public void onResponse(Call<ArrayList<StudentModel>> call, Response<ArrayList<StudentModel>> response) {
//                 if ((response.isSuccessful() && response.body() != null)) {
//                     StudentModel s = new StudentModel();
//                     arrstudents.addAll(response.body());
//                     adapter.notifyDataSetChanged();
//                 }
//             }
//
//             @Override
//             public void onFailure(Call<ArrayList<StudentModel>> call, Throwable t) {
//                 Toast.makeText(context, "error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//             }
//         });
//    }
    public void setRecyclerVew() {

        test test_ = new test() {
            @Override
            public void itemClick(int position) {
                position = position;
                adapter.position = position;
                StudentModel studentModel = arrstudents.get(position);
                Intent intent = new Intent(MainActivity.this, MyApplicationStudent2.class);
                intent.putExtra("Updation", studentModel);
                startActivityForResult(intent, 3);

            }
        };
        adapter = new RecyclerStudentAdapter(context, arrstudents, test_);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

    }

    /*  private void InsertData() {
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum"));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum"));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum"));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum"));
          arrstudents.add(new StudentModel(R.drawable.ic_launcher_foreground, "Palak", "8815531004","abc@123","482004","Lorem ipsum "));

      }*/
    private void setClickListener() {
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MyApplicationStudent2.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            Toast.makeText(context, requestCode + "" + adapter.position, Toast.LENGTH_SHORT).show();
            if (requestCode == 2) {
                String name = data.getStringExtra("NAME");
                String number = data.getStringExtra("NUMBER");
                String email = data.getStringExtra("EMAIL");
                String zipcode = data.getStringExtra("ZIPCODE");
                String about = data.getStringExtra("ABOUT");
                String hobby = data.getStringExtra("HOBBY");



                StudentModel s = new StudentModel();
                s.name = name;
                s.email = email;
                s.num = number;
                s.zipcode = zipcode;
                s.about = about;
                s.hobby = hobby;

                arrstudents.add(s);
                adapter.notifyItemInserted(arrstudents.size() - 1);
                recyclerView.scrollToPosition(arrstudents.size() - 1);
            } else if (requestCode == 3) {


                String name = data.getStringExtra("NAME");
                String number = data.getStringExtra("NUMBER");
                String email = data.getStringExtra("EMAIL");
                String zipcode = data.getStringExtra("ZIPCODE");
                String about = data.getStringExtra("ABOUT");

                StudentModel s = new StudentModel();
                s.name = name;
                s.email = email;
                s.num = number;
                s.zipcode = zipcode;
                s.about = about;

                arrstudents.set(adapter.position, s);
                adapter.notifyItemChanged(adapter.position);
            }

        } catch (Exception e) {
            Log.e("error", e.getMessage());
        }
    }


}




