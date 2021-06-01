package com.example.factsproblemstatement;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;


public class Fact2 extends Fragment {

    Button btnChangeColor2;
    LinearLayout layout2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fact2, container, false);

        //---------------SpellCasting------------
        btnChangeColor2 = view.findViewById(R.id.btnColorChange2);
        layout2 = view.findViewById(R.id.layout2);
        //---------------SpellCasting------------


        btnChangeColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout2.setBackgroundColor(getRandomColor());
            }
        });

        return view;
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}