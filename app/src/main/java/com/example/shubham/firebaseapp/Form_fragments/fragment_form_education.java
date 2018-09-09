package com.example.shubham.firebaseapp.Form_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shubham.firebaseapp.R;

public class fragment_form_education extends Fragment {

    View view;
EditText qualification_edu , language_edu , skills_edu , passing_year_edu ,college_edu;


    ViewPager viewPager;

    public fragment_form_education() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_form_education , container , false);
        qualification_edu = view.findViewById(R.id.form_education_qualification);
        skills_edu  =view.findViewById(R.id.form_education_skills);
        language_edu = view.findViewById(R.id.form_education_language);
        college_edu = view.findViewById(R.id.form_education_college);
        passing_year_edu = view.findViewById(R.id.form_education_passingyear);

        Button donebtn = view.findViewById(R.id.from_education_doneBTN);


        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!all_fields()) {
                    Toast.makeText(getActivity(),"fill info correctly" , Toast.LENGTH_SHORT ).show();
                }

                else{
                    Toast.makeText(getActivity(),"success" , Toast.LENGTH_SHORT ).show();

                    viewPager = getActivity().findViewById(R.id.form_ViewPager);
                    viewPager.setCurrentItem(2);

                }
            }
        });



        return view;
    }



    private boolean all_fields(){
        String college =college_edu.getText().toString();
        String language =language_edu.getText().toString();
        String qualification =qualification_edu.getText().toString();
        String passing_year =passing_year_edu.getText().toString();
        String skills =skills_edu.getText().toString();



        if(qualification.isEmpty()){
            return false;
        }

        if(college.isEmpty()){
            return  false;
        }

        if(language.isEmpty()){
            return false;
        }
        if(passing_year.isEmpty() || passing_year.length()!=4 ){
            return false;
        }
        if(skills.isEmpty()){
            return false;
        }


        return true;
    }

}
