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
import android.widget.EditText;
import android.widget.Toast;

import com.example.shubham.firebaseapp.R;
import com.example.shubham.firebaseapp.employer_verification;

public class fragment_employer_form extends Fragment {

    View view;
    Button next;
    EditText employer_name , employer_post , company_name,company_website, contact_number,contact_email , location;

    String E_name ;
    String E_post;
    String C_name ;
    String C_url ;
    String E_phone ;
    String E_email ;
    String E_location;
    public fragment_employer_form() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_employer_form , container , false);
        next = view.findViewById(R.id.form_employer_doneBTN);

        employer_name = view.findViewById(R.id.personal_name_employer);
        employer_post = view.findViewById(R.id.personal_post_employer);
        company_name = view.findViewById(R.id.personal_companyname_employer);
        company_website = view.findViewById(R.id.personal_companyURL_employer);
        contact_number = view.findViewById(R.id.personal_phone_employer);
        contact_email = view.findViewById(R.id.personal_email_employer);
        location = view.findViewById(R.id.personal_location_employer);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(is_filled()) {

                    //Add code for firebase here to add data to the server



                    Toast.makeText(getActivity(),"success" , Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent(getActivity(), employer_verification.class);

                    intent.putExtra("NAME",E_name);
                    intent.putExtra("PHONE",E_phone);
                    intent.putExtra("LOCATION",E_location);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getActivity(),"fill all fields correctly" , Toast.LENGTH_SHORT ).show();

                }
            }
        });




        return view;
    }


    private boolean is_filled(){
       E_name = employer_name.getText().toString();
       E_post = employer_post.getText().toString();
       C_name = company_name.getText().toString();
       C_url = company_website.getText().toString();
       E_phone = contact_number.getText().toString();
       E_email = contact_email.getText().toString();
       E_location = location.getText().toString();


        if(E_name.isEmpty()){
            return false;
        }

        if(E_post.isEmpty()){
            return false;
        }

        if(C_name.isEmpty()){
            return false;
        }
        if(C_url.isEmpty()){
            return false;
        }
        if(E_phone.isEmpty() || E_phone.length() != 10){
            return false;
        }
        if(E_email.isEmpty()){
            return false;
        }

        if(E_location.isEmpty()){
            return false;
        }


        return true;
    }



}
