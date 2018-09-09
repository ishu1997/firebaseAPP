package com.example.shubham.firebaseapp.employer_form_fragemments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class employer_viewpager_adapter extends FragmentPagerAdapter {

    private final List<Fragment> fragment_list = new ArrayList<>();
    private final List<String> fragment_title = new ArrayList<>();

    public employer_viewpager_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragment_list.get(i);
    }



    @Override
    public int getCount() {
        return fragment_title.size() ;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragment_title.get(position);
    }

    public void Add_fragment(Fragment fragment , String title){

        fragment_list.add(fragment);
        fragment_title.add(title);
    }


}
