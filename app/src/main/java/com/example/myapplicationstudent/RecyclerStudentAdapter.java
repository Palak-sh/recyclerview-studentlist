package com.example.myapplicationstudent;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerStudentAdapter extends RecyclerView.Adapter<RecyclerStudentAdapter.ViewHolder> {
    Context context;
    ArrayList<StudentModel> arrstudents = new ArrayList<>();
    private ViewHolder holder;
    public int position;
   public test test_;

    RecyclerStudentAdapter(Context context, ArrayList<StudentModel> arrstudents, test test_) {
        this.context = context;
        this.arrstudents = arrstudents;
        this.test_= test_;
    }
    public RecyclerStudentAdapter(Context context, ArrayList<StudentModel> arrstudents) {
        this.arrstudents = arrstudents;
        this.context = context;

    }
    @NonNull
    @Override
    public RecyclerStudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v ;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerStudentAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = position;
        final StudentModel temp = arrstudents.get(position);

        holder.imgContact.setImageResource(arrstudents.get(position).img);

        holder.txtName.setText(arrstudents.get(position).name);
        //holder.txtNumber.setText(arrstudents.get(position).userId);
        holder.txtNumber.setText(arrstudents.get(position).num);
        holder.txtEmail.setText(arrstudents.get(position).email);
        //holder.txtEmail.setText(arrstudents.get(position).completed);
        //holder.txtAbout.setText(arrstudents.get(position).title);
        holder.txtAbout.setText(arrstudents.get(position).about);
        holder.txtZipcode.setText(arrstudents.get(position).id);
        holder.txtZipcode.setText(arrstudents.get(position).zipcode);
      //  holder.txtHobbies.setText(arrstudents.get(position).hobby);
       // holder.txtHobbies.setText("HOBBY");
        holder.imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MainActivityStudent3.class);
                 intent.putExtra("StudentModel",temp);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Student")
                        .setMessage("Are u sure u want 2 delete?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                arrstudents.remove(position);
                                notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                            }
                        });
                builder.show();
            }
        });

            holder.btnupdate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    test_.itemClick(position);


                   /*          Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.update_lay);
                EditText username = dialog.findViewById(R.id.username);
                EditText usercontact = dialog.findViewById(R.id.usercontact);
                EditText useremail = dialog.findViewById(R.id.Email);
                EditText userzipcode = dialog.findViewById(R.id.Zipcode);
                EditText userabout = dialog.findViewById(R.id.About);

                Button btnAction = dialog.findViewById(R.id.btnaction);
                TextView register = dialog.findViewById(R.id.register);
                register.setText("UPDATE");


                username.setText(arrstudents.get(position).name);
                usercontact.setText(arrstudents.get(position).num);
                useremail.setText(arrstudents.get(position).email);
                userzipcode.setText(arrstudents.get(position).zipcode);
                userabout.setText(arrstudents.get(position).about);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = username.getText().toString();
                        String number = usercontact.getText().toString();
                        String email = useremail.getText().toString();
                        String zipcode = userzipcode.getText().toString();
                        String about = userabout.getText().toString();
                        arrstudents.set(position,new StudentModel(name,number,email,zipcode,about));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();*/
                }

            });



    }


    @Override
    public int getItemCount() {
        return arrstudents.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtName)
                TextView txtName;
        @BindView(R.id.txtNumber)
        TextView txtNumber;
        @BindView(R.id.txtEmail)
        TextView txtEmail;
        @BindView(R.id.txtZipcode)
        TextView txtZipcode;
        @BindView(R.id.txtAbout)
        TextView txtAbout;
        @BindView(R.id.txtHobbies)
        TextView txtHobbies;
        @BindView(R.id.imgContact)
        ImageView imgContact;
        @BindView(R.id.btndelete)
                Button btndelete;
        @BindView(R.id.btnupdate)
        Button btnupdate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);







        }

    }

}