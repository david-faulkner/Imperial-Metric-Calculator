package com.example.imperial_metriccalculator;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

//class to handle holding the fragments
public class FragmentStatePagerAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {

    //list that holds the fragments themselves
    private final List<Fragment> fragmentList = new ArrayList<>();

    public FragmentStatePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //adds fragments to the list
    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
