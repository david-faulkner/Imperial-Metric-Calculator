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
        getMenuInflater().inflate(
                R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()) {
            case R.id.distOption:
                //display pop up
                Toast.makeText(this, "Switching to distance conversion...", Toast.LENGTH_LONG);

                //nav to next fragment
                viewPager.setCurrentItem(1);

                return true;
            case R.id.tempOption:
                //display pop up
                Toast.makeText(this, "Switching to temperature conversion...", Toast.LENGTH_LONG);

                //nav to next fragment
                viewPager.setCurrentItem(0);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //function to set up the ViewPager with new fragments
    public void createViewPager(ViewPager pager) {
        FragmentStatePagerAdapter tempAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager());
        tempAdapter.addFragment(new Temperature());
        tempAdapter.addFragment(new Distance());
        pager.setAdapter(tempAdapter);
    }

}
