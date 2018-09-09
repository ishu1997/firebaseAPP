package com.example.shubham.firebaseapp.employer_form_fragemments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shubham.firebaseapp.R;
import com.example.shubham.firebaseapp.employer_verification;

public class fragment_employer_form extends Fragment {

    View view;
    Button next;
    public fragment_employer_form() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_employer_form , container , false);
        next = view.findViewById(R.id.form_employer_doneBTN);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity()  ,employer_verification.class);
                startActivity(intent);
            }
        });




        return view;
    }


}
