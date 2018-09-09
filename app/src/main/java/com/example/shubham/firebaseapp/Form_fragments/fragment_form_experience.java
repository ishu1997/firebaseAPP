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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shubham.firebaseapp.R;

public class fragment_form_experience extends Fragment {
    View view;
    ViewPager viewPager;
    RadioGroup radioGroup ;
    RadioButton radio_fresher , radio_experience;
    Button done_btn;

    EditText yearText , monthText , descriptionText;
    LinearLayout experience_layout;

    public fragment_form_experience() {

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_from_experience , container , false);

        done_btn = view.findViewById(R.id.form_exp_doneBTN);
        radioGroup = view.findViewById(R.id.form_exp_Radiogroup);
        radio_fresher = view.findViewById(R.id.form_fresher_radiobutton);
        radio_experience = view.findViewById(R.id.form_exp_radiobutton);

        yearText = view.findViewById(R.id.form_exp_year);
        monthText = view.findViewById(R.id.form_exp_month);
        descriptionText = view.findViewById(R.id.form_exp_description);

        experience_layout = view.findViewById(R.id.experienced_column);



//setting up done button

        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"success" , Toast.LENGTH_SHORT).show();
                viewPager = getActivity().findViewById(R.id.form_ViewPager);
                viewPager.setCurrentItem(3);
            }
        });


        //settin up radio buttons

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

                switch(checkedId) {
                    case R.id.form_exp_radiobutton:
                        //visible the desc and year/months
                        experience_layout.setVisibility(View.VISIBLE);

                        break;

                    case R.id.form_fresher_radiobutton:
                        //invisible the desc and year/months
                        experience_layout.setVisibility(View.GONE);

                        break;
                }


            }
        });









        return view;
    }

}
