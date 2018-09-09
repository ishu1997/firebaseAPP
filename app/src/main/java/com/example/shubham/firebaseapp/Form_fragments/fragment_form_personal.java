package com.example.shubham.firebaseapp.Form_fragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.shubham.firebaseapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class fragment_form_personal extends Fragment {

    View view;
    ViewPager viewPager;
    Button Done_personal;
    EditText personal_name , personal_email , personal_location, personal_phone , personal_dob;
    ImageButton calendar_Button;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    public fragment_form_personal() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.fragment_form_personal , container , false);
        personal_name = view.findViewById(R.id.personal_name_Etext);
        personal_email = view.findViewById(R.id.personal_email_Etext);
        personal_location = view.findViewById(R.id.personal_location_Etext);
        personal_phone = view.findViewById(R.id.personal_phone_Etext);
        personal_dob = view.findViewById(R.id.personal_dob_Etext);
        Done_personal = view.findViewById(R.id.form_personal_doneBTN);
        calendar_Button = view.findViewById(R.id.form_personal_calendar);



// calendar lagic here

        calendar_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                       android.R.style.Theme_Material_Dialog_Alert,dateSetListener,year,month,day);

               datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
               datePickerDialog.show();

            }
        });


        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
               String DOB = day+"/"+month+"/"+year;
                personal_dob.setText(DOB);

            }
        };


        //done button logic here----

        Done_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!all_fields()) {
            Toast.makeText(getActivity(),"fill info correctly" , Toast.LENGTH_SHORT ).show();
        }

        else{
            Toast.makeText(getActivity(),"success" , Toast.LENGTH_SHORT ).show();

                viewPager = getActivity().findViewById(R.id.form_ViewPager);
                viewPager.setCurrentItem(1);

                }
                }
        });



        return view;
    }


    private boolean all_fields(){
        String name =personal_name.getText().toString();
        String email =personal_email.getText().toString();
        String location =personal_location.getText().toString();
        String phone =personal_phone.getText().toString();
        String dob =personal_dob.getText().toString();



        if(name.isEmpty()){
            return false;
        }

        if(email.isEmpty()){
            return  false;
        }

        if(location.isEmpty()){
            return false;
        }
        if(phone.isEmpty() || phone.length()<10 ){
            return false;
        }
        if(dob.isEmpty()){
            return false;
        }


        return true;
    }




}
