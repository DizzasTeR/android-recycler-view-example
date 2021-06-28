package com.dizzasterapps.abcapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlphabetHolder extends RecyclerView.ViewHolder {
    ImageView m_AlphabetImage;
    TextView m_AlphabetTitle;
    TextView m_AlphabetDescription;

    public AlphabetHolder(@NonNull View itemView) {
        super(itemView);

        m_AlphabetImage = itemView.findViewById(R.id.alphabetImage);
        m_AlphabetTitle = itemView.findViewById(R.id.alphabetTitle);
        m_AlphabetDescription = itemView.findViewById(R.id.alphabetDescription);
    }
}
