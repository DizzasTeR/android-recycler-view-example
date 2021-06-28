package com.dizzasterapps.abcapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    RecyclerView m_MainView;
    ArrayList<String> m_Letters = new ArrayList<String>();
    String [] m_LetterDescriptions;
    final int[] m_LettersImages = {
            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f,
            R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l,
            R.drawable.m, R.drawable.n, R.drawable.o, R.drawable.p, R.drawable.q, R.drawable.r,
            R.drawable.s, R.drawable.t, R.drawable.u, R.drawable.v, R.drawable.w, R.drawable.x,
            R.drawable.y, R.drawable.z
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize our letters data
        for(int c = 'a'; c <= 'z'; c++)
            m_Letters.add(String.valueOf((char) c).toUpperCase());
        m_LetterDescriptions = getResources().getStringArray(R.array.letter_descriptions);

        m_MainView = findViewById(R.id.mainView);
        m_MainView.setLayoutManager(new LinearLayoutManager(this));
        m_MainView.setAdapter(new AlphabetRecyclerView(this, m_Letters, m_LettersImages, m_LetterDescriptions));
    }
}