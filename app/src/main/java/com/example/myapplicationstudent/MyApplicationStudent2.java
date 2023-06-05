package com.example.myapplicationstudent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyApplicationStudent2 extends AppCompatActivity {
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.button)
    Button btnAction;
    @BindView(R.id.ll)
   LinearLayout ll;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.Email)
    EditText Email;
    @BindView(R.id.fstTxt)
    TextView fstTxt;
    @BindView(R.id.usercontact)
    EditText usercontact;

    @BindView(R.id.Zipcode)
    EditText Zipcode;
    @BindView(R.id.About)
    EditText About;
    @BindView(R.id.add)
    ImageView add;
    Button btnupdate;
    RecyclerStudentAdapter adapter;
    RecyclerView rv;
    boolean isAllFieldsChecked = false;
    ArrayList<StudentModel> arrstudents = new ArrayList<>();
    Context context;
    @SuppressLint("RecyclerView") private int position;
    public int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application_student2);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);


        LinearLayout layout = new LinearLayout(MyApplicationStudent2.this);
        Binding();
       EditText tv1,tv2,tv3,tv4,tv6,tv7;
       ImageView img;
        tv1 = (EditText) findViewById(R.id.username);
        tv2= (EditText) findViewById(R.id.Email);
        tv3= (EditText) findViewById(R.id.usercontact);
        tv4= (EditText) findViewById(R.id.Zipcode);
        tv6= (EditText) findViewById(R.id.About);
        img = (ImageView) findViewById(R.id.add);




        Intent intent = this.getIntent();
        try {
            StudentModel studentModel = (StudentModel) getIntent().getSerializableExtra("Updation");
            tv1.setText(studentModel.name);
            tv2.setText(studentModel.email);
            tv3.setText(studentModel.num);
            tv4.setText(studentModel.zipcode);
            tv6.setText(studentModel.about);


        }catch (Exception e){
            System.out.println(e);
        }

       if(!(username.length()==0)) {
        TextView register =findViewById(R.id.textView);
        register.setText("UPDATE");
           Button b =findViewById(R.id.button);
           b.setText("UPDATE");}
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          if(username.getText().toString().trim().length() == 0){
                   isAllFieldsChecked = CheckAllFields();
                   String name = username.getText().toString();
                   String number = usercontact.getText().toString();
                   String email = Email.getText().toString();
                   String zipcode = Zipcode.getText().toString();
                   String about = About.getText().toString();

 /*                  EditText ed;
                   List<EditText> editText = new ArrayList<EditText>();
                   for(int i = 0; i<ll.getChildCount();i++){
                       if(ll.getChildAt(i) instanceof LinearLayoutCompat){

                           LinearLayoutCompat l = (LinearLayoutCompat) ll.getChildAt(i);
                           for(int j = 0; j<l.getChildCount();j++){
                               if(l.getChildAt(j) instanceof EditText){
                                   EditText et = (EditText)l.getChildAt(j);
                                   if (et.getId() == R.id.dynamicedittext){
                                       Toast.makeText(context,"" + et.getText().toString(), Toast.LENGTH_LONG).show();
                                   }
                               }
                           }
                       }
                   }*/
   /*           EditText ed;
              List<EditText> editText = new ArrayList<EditText>();

                   for (int i = 0; i < count; i++) {

                       ed = new EditText(MyApplicationStudent2.this);
                       editText.add(ed);
                       ed.setId(count);
                       ed.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT,
                               RelativeLayout.LayoutParams.WRAP_CONTENT));
                       ll.addView(ed);
                   }
                   String[] strings = new String[editText.size()];
                   int i;
                   for (i = 0; i < editText.size(); i++) {
                       strings[i] = editText.get(i).getText().toString();
                   }*/
//              int i;
//              String[] strings = new String[ll.getChildCount()];
//
//              for ( i=0; i < ll.getChildCount(); i++){
//                  EditText e = (EditText)ll.getChildAt(i);
//                  strings[i] = e.getText().toString();
//              }

                   if (isAllFieldsChecked) {
                       Intent intent = new Intent();
                       intent.putExtra("NAME", name);
                       intent.putExtra("NUMBER", number);
                       intent.putExtra("EMAIL", email);
                       intent.putExtra("ZIPCODE", zipcode);
                       intent.putExtra("ABOUT", about);
    //                   intent.putExtra("HOBBY", strings[i]);


                       setResult(2, intent);
                       finish();
                   } else {
                       Toast.makeText(MyApplicationStudent2.this, "INVALID", Toast.LENGTH_SHORT).show();
                   }
               }else{
                   isAllFieldsChecked = CheckAllFields();
                   String name = username.getText().toString();
                   String number = usercontact.getText().toString();
                   String email = Email.getText().toString();
                   String zipcode = Zipcode.getText().toString();
                   String about = About.getText().toString();

                   if (isAllFieldsChecked) {
                       Intent intent = new Intent();
                       intent.putExtra("NAME", name);
                       intent.putExtra("NUMBER", number);
                       intent.putExtra("EMAIL", email);
                       intent.putExtra("ZIPCODE", zipcode);
                       intent.putExtra("ABOUT", about);

                       setResult(3, intent);
                       finish();
                   } else {
                       Toast.makeText(MyApplicationStudent2.this, "INVALID", Toast.LENGTH_SHORT).show();
                   }

               }
            }
        });


      add.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              createHobbies();
          }
      });


    }

    private void createHobbies() {

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.setMargins(0,10,0,10);
        EditText editText = new EditText(this);
        int maxLength = 1000;
        count++;
        editText.setHint("hobby"+count);
        editText.setLayoutParams(params);
        // edtTxt.setBackgroundColor(Color.WHITE);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        editText.setId(count);
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        editText.setFilters(fArray);
        ll.addView(editText);

        /*String[] strings = new String[editText.length()];

        for(int i = 0; i<editText.length();i++){
            strings[i] = editText.getText().toString();
        }
        final View v = getLayoutInflater().inflate(R.layout.dynamichobby,null,false);
        ImageView cross = (ImageView)v.findViewById(R.id.cross);
        cross.setVisibility(View.VISIBLE);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeView(v);
            }
        });
        ll.addView(v);
*/
    }

//    private void removeView(View v) {
//        ll.removeView(v);
//    }

    private boolean CheckAllFields() {


        if (username.length() == 0) {
            username.setError("This field is required");
            return false;
        }else if(!(username.getText().toString().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$")))
        {
            username.requestFocus();
            username.setError("ENTER ONLY ALPHABETICAL CHARACTER");
            return false;
        }

        else if(fstTxt.length()==0)
        {
            fstTxt.requestFocus();
            fstTxt.setError("FIELD CANNOT BE EMPTY");
            return false;
        }


        if (Email.length() == 0) {
            Email.setError("Email is required");
            return false;
        } else if(!Email.getText().toString().matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$"))
        {
            Email.requestFocus();
            Email.setError("ENTER VALID EMAIL ADDRESS");
            return false;
        }


        if (usercontact.length() == 0) {
            usercontact.setError("This field is required");
            return false;
        } else if (usercontact.length() < 10) {
            usercontact.setError("This field requires minimum 10 digits");
            return false;
        } else if (usercontact.length() > 10) {
            usercontact.setError("This field can't extend the length of 10 digits");
            return false;
        } else if(!usercontact.getText().toString().matches("^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$"))
        {
            usercontact.requestFocus();
            usercontact.setError("ENTER VALID MOBILE NUMBER");
            return false;
        }

        if (Zipcode.length() == 0) {
            Zipcode.setError("This field is required");
            return false;
        } else if (Zipcode.length() < 6) {
            Zipcode.setError("Invalid zipcode");
            return false;
        } else if (Zipcode.length() > 6) {
            Zipcode.setError("Invalid zipcode");
            return false;
        }else if(!Zipcode.getText().toString().matches("[0-9]+"))
        {
           Zipcode.requestFocus();
           Zipcode.setError("PLEASE ENTER VALID ZIP CODE");
            return false;
        }



        return true;
    }
    private void Binding(){

        View view = getLayoutInflater().inflate(R.layout.student_row, null);
        btnupdate = (Button) view.findViewById(R.id.btnupdate);


    }

}

