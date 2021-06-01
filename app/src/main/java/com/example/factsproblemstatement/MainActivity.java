package com.example.factsproblemstatement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //------------------DeclareZone----------------
    ArrayList <Fragment> al;
    MyFragPageAdapter adapter;
    ViewPager vPager;
    Button btnLtr;
    //------------------DeclareZone----------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //---------------SpellCasting------------
        vPager = findViewById(R.id.viewpager1);
        btnLtr = findViewById(R.id.btnReadLater);
        //---------------SpellCasting------------


        //=================Swipe Usage=============
        FragmentManager fm = getSupportFragmentManager();
        al = new ArrayList<Fragment>();
        al.add(new Fact1());
        al.add(new Fact2());
        al.add(new Fact3());

        adapter = new MyFragPageAdapter(fm, al);
        vPager.setAdapter(adapter);
        //=================Swipe Usage=============



        //==================btnReadLtr==================
        btnLtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //==================btnReadLtr==================




    } ///--------SpellCastEnds---------


    //=====================Menu Handle================
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_next:
                int max = vPager.getChildCount();
                if (vPager.getCurrentItem() < max-1){
                    int nextPage = vPager.getCurrentItem() + 1;
                    vPager.setCurrentItem(nextPage, true);
                }
                return true;

            case R.id.action_previous:
                if (vPager.getCurrentItem() > 0){
                    int previousPage = vPager.getCurrentItem() - 1;
                    vPager.setCurrentItem(previousPage, true);
                }
                return true;

            case R.id.action_random:

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //=====================Menu Handle================


    //===============Inflate OptionMenu================
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //===============Inflate OptionMenu================
} //--------Ending---------