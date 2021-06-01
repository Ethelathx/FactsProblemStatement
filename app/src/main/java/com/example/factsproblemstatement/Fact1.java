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

public class Fact1 extends Fragment {

    Button btnChangeColor;
    LinearLayout layout1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fact1, container, false);

        //---------------SpellCasting------------
        btnChangeColor = view.findViewById(R.id.btnColorChange);
        layout1 = view.findViewById(R.id.layout1);
        //---------------SpellCasting------------


        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout1.setBackgroundColor(getRandomColor());
            }
        });

        return view;
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}

