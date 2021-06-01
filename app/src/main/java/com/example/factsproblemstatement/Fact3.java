package com.example.factsproblemstatement;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class Fact3 extends Fragment {

    Button btnChangeColor3;
    LinearLayout layout3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fact3, container, false);

        //---------------SpellCasting------------
        btnChangeColor3 = view.findViewById(R.id.btnColorChange3);
        layout3 = view.findViewById(R.id.layout3);
        //---------------SpellCasting------------


        btnChangeColor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout3.setBackgroundColor(getRandomColor());
            }
        });

        return view;
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}