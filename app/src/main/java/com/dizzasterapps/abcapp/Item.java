package com.dizzasterapps.abcapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.R)
public class Item extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextToSpeech m_TTS;
    boolean m_TTSReady = false;

    ImageView m_AlphabetImage;
    TextView m_AlphabetTitle;
    TextView m_AlphabetDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        m_TTS = new TextToSpeech(this, this);

        m_AlphabetImage = findViewById(R.id.imageView);
        m_AlphabetTitle = findViewById(R.id.textViewTitle);
        m_AlphabetDescription = findViewById(R.id.textViewDescription);

        Intent intent = getIntent();
        final int imageResource = intent.getIntExtra("imageResource", R.drawable.ic_launcher_background);
        final String alphabet = intent.getStringExtra("alphabet").toLowerCase();
        final String alphabetDescription = intent.getStringExtra("description");

        m_AlphabetImage.setImageResource(imageResource);
        m_AlphabetTitle.setText(alphabet);
        m_AlphabetDescription.setText(alphabetDescription);
    }

    @Override
    protected void onDestroy() {
        if(m_TTS.isSpeaking())
            m_TTS.stop();

        m_TTS.shutdown();
        m_TTS = null;

        super.onDestroy();
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            m_TTS.setSpeechRate(0.5f);
            m_TTSReady = true;

            m_TTS.speak(m_AlphabetTitle.getText(), TextToSpeech.QUEUE_FLUSH, null, null);
        }
        else
            Toast.makeText(this, "Failed to initialize TTS", Toast.LENGTH_SHORT).show();
    }

    public void onButtonClick_PlaySound(View view) {
        if(m_TTSReady) {
            if (m_TTS.isSpeaking())
                return;

            m_TTS.speak(m_AlphabetTitle.getText(), TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }

    public void onButtonClick_PlayDescription(View view) {
        if(m_TTSReady) {
            if(m_TTS.isSpeaking())
                return;
            m_TTS.speak(m_AlphabetDescription.getText(), TextToSpeech.QUEUE_FLUSH, null, null);
        }
    }
}