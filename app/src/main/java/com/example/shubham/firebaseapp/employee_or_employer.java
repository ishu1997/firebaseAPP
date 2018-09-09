package com.example.shubham.firebaseapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class employee_or_employer extends AppCompatActivity {

    Button employee;
    Button employer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_or_employer);
        employee = findViewById(R.id.select_employee);
        employer = findViewById(R.id.select_employer);


    }

        public void start_form_employee(View view){

        Intent intent = new Intent(this , FormActivity.class);
        startActivity(intent);
        }


        public void start_form_employer(View view){

            Intent intent = new Intent(this ,Employer_form.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext() ,"employer clicked" , Toast.LENGTH_SHORT).show();

        }


}



