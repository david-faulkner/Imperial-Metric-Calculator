package com.example.imperial_metriccalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up fragments and ViewPager for switching
        viewPager = (ViewPager) findViewById(R.id.placeholderContainer);
        createViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //inflate the menu when the overflow icon is clicked
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //item in the overflow menu is clicked
        switch(item.getItemId()) {
            case R.id.distOption:
                //nav to distance fragment
                viewPager.setCurrentItem(1);

                return true;
            case R.id.tempOption:
                //nav to temperature fragment
                viewPager.setCurrentItem(0);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //function to set up the ViewPager with new fragments
    public void createViewPager(ViewPager pager) {
        FragmentStatePagerAdapter tempAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager());
        tempAdapter.addFragment(new Temperature()); //index 0, defaults to this fragment
        tempAdapter.addFragment(new Distance()); //index 1
        pager.setAdapter(tempAdapter);
    }

}
