package com.example.shubham.firebaseapp;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shubham.firebaseapp.Form_fragments.fragment_form_education;
import com.example.shubham.firebaseapp.Form_fragments.fragment_form_experience;
import com.example.shubham.firebaseapp.Form_fragments.fragment_form_personal;
import com.example.shubham.firebaseapp.Form_fragments.fragment_form_prefrences;

public class FormActivity extends AppCompatActivity {

    public AppBarLayout appBarLayout;
    public ViewPager viewPager;
    public TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        appBarLayout = findViewById(R.id.form_AppBar);
        viewPager = findViewById(R.id.form_ViewPager);
        tabLayout = findViewById(R.id.form_TabLayout);

        //defined class
        form_viewPager_adapter adapter = new form_viewPager_adapter(getSupportFragmentManager());

        //adding fragments in the adpater
        adapter.Add_fragment(new fragment_form_personal() , "Personal");
        adapter.Add_fragment(new fragment_form_education() , "Education");
        adapter.Add_fragment(new fragment_form_experience() , "Experience");
        adapter.Add_fragment(new fragment_form_prefrences() , "Preferences");

        // adding adapter to the view pager
        viewPager.setAdapter(adapter);


        //adding view pager to the tab layout
        tabLayout.setupWithViewPager(viewPager);


    }

    //function for personal_done button clicked



}
