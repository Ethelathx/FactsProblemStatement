package com.example.factsproblemstatement;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.crazyhitty.chdev.ks.rssmanager.RSS;
import com.crazyhitty.chdev.ks.rssmanager.RssReader;

import java.util.List;
import java.util.Random;

public class Fact3 extends Fragment implements RssReader.RssCallback {

    Button btnChangeColor3;
    LinearLayout layout3;
    TextView tvRSS;
    private RssReader rssReader = new RssReader(this);
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fact3, container, false);
        rssReader.loadFeeds("https://www.singstat.gov.sg/rss");
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

    @Override
    public void rssFeedsLoaded(List<RSS> rssList) {
        Random rand = new Random();
        int number = rand.nextInt(rssList.get(0).getChannel().getItems().size());
        String title = rssList.get(0).getChannel().getItems().get(number).getTitle();
        String desc = rssList.get(0).getChannel().getItems().get(number).getDescription();
        String link = rssList.get(0).getChannel().getItems().get(number).getLink();
        tvRSS = getActivity().findViewById(R.id.textViewRss);
        tvRSS.setText("Title: "+title+"\n\n"+"Description: "+desc+"\n\n"+"Link: "+link+"\n\n");
    }

    @Override
    public void unableToReadRssFeeds(String errorMessage) {
        Toast.makeText(getContext(), "Unable to read RSS!", Toast.LENGTH_SHORT).show();
    }
}