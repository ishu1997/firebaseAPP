package com.example.shubham.firebaseapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class employer_verification extends AppCompatActivity {
Button generate_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_verification);

        generate_code = findViewById(R.id.generate_code_employer);

        generate_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






              //  ------code for email sent--------

                Log.i("Send email", "");

                String[] TO = {"mightymajestic1997@gmail.com"};
                String[] CC = {"shubhammauryaishu@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(),
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }


            }



    });




    }



    public void verfication_done(View view){


        Intent intent = new Intent(this , job_post.class);
        startActivity(intent);
    }

}
