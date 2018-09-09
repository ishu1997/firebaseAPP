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
import com.example.shubham.firebaseapp.employer_form_fragemments.employer_viewpager_adapter;
import com.example.shubham.firebaseapp.employer_form_fragemments.fragment_employer_form;

public class Employer_form extends AppCompatActivity {
    public AppBarLayout appBarLayout;
    public ViewPager viewPager;
    public TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_form);



        appBarLayout = findViewById(R.id.form_employer_AppBar);
        viewPager = findViewById(R.id.form_employer_ViewPager);
        tabLayout = findViewById(R.id.form_employer_TabLayout);

        //defined class
       employer_viewpager_adapter adapter = new employer_viewpager_adapter(getSupportFragmentManager());

        //adding fragments in the adpater
        adapter.Add_fragment(new fragment_employer_form(), "Profile setup");
//        adapter.Add_fragment(new fragment_form_education() , "Education");
//        adapter.Add_fragment(new fragment_form_experience() , "Experience");
//        adapter.Add_fragment(new fragment_form_prefrences() , "Preferences");

        // adding adapter to the view pager
        viewPager.setAdapter(adapter);


        //adding view pager to the tab layout
        tabLayout.setupWithViewPager(viewPager);

    }
}
