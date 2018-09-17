package com.example.shubham.firebaseapp;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Calendar;

public class job_post extends AppCompatActivity {

    Button Done_job_post;
    EditText job_post_designation,job_post_companyname,job_post_salary ,job_post_vacancies, job_post_email , job_post_location,job_post_description , job_post_date;
    ImageButton calendar_Button;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_post);

        job_post_date = findViewById(R.id.job_post_endDate);
        job_post_description = findViewById(R.id.job_post_description);
        job_post_designation = findViewById(R.id.job_post_designation);
        job_post_companyname = findViewById(R.id.job_post_companyname);
        job_post_email = findViewById(R.id.job_post_email);
        job_post_location = findViewById(R.id.job_post_location);
        job_post_salary = findViewById(R.id.job_post_salary);
        job_post_vacancies = findViewById(R.id.job_post_vacancies);
        calendar_Button  = findViewById(R.id.job_post_calendar);
        Done_job_post= findViewById(R.id.job_post_doneBTN);




        calendar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

              //  DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(),
                //        android.R.style.Theme_Material_Dialog_Alert,dateSetListener,year,month,day);

                DatePickerDialog datePickerDialog = new DatePickerDialog(job_post.this,
                        android.R.style.Theme_Material_Dialog_Alert,dateSetListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });


        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String DATE = day+"/"+month+"/"+year;
                job_post_date.setText(DATE);

            }
        };



        Done_job_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!all_fields()) {
                    Toast.makeText(getApplicationContext(),"fill info correctly" , Toast.LENGTH_SHORT ).show();
                }

                else{
                    Toast.makeText(getApplicationContext(),"success" , Toast.LENGTH_SHORT ).show();



                }
            }
        });





    }




    private boolean all_fields(){
        String designation =job_post_designation.getText().toString();
        String companyname = job_post_companyname.getText().toString();
        String salary = job_post_salary.getText().toString();
        String vacancies = job_post_vacancies.getText().toString();
        String email =job_post_email.getText().toString();
        String location =job_post_location.getText().toString();
        String description =job_post_description.getText().toString();
        String date =job_post_date.getText().toString();

        if(vacancies.isEmpty()){
            return false;
        }

        if(salary.isEmpty()){
            return false;
        }

        if(companyname.isEmpty()){
            return false;
        }
        if(designation.isEmpty()){
            return false;
        }

        if(email.isEmpty()){
            return  false;
        }

        if(location.isEmpty()){
            return false;
        }
        if(description.isEmpty()  || description.length()>50 ){
            return false;
        }

        if(date.isEmpty()){
            return false;
        }


        return true;
    }



}
