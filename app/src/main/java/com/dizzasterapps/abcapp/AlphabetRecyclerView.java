package com.dizzasterapps.abcapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlphabetRecyclerView extends RecyclerView.Adapter {
    Context m_Context;
    ArrayList<String> m_Alphabets;
    String[] m_AlphabetDescriptions;
    int[] m_AlphabetImages;

    public AlphabetRecyclerView(@NonNull Context context, ArrayList<String> alphabets, int[] alphabetImages, String[] alphabetDescriptions) {
        m_Context = context;
        m_Alphabets = alphabets;
        m_AlphabetDescriptions = alphabetDescriptions;
        m_AlphabetImages = alphabetImages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_Context).inflate(R.layout.alphabetcardlayout, parent, false);
        return new AlphabetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((AlphabetHolder) holder).m_AlphabetTitle.setText(m_Alphabets.get(position));
        ((AlphabetHolder) holder).m_AlphabetDescription.setText(m_AlphabetDescriptions[position]);
        ((AlphabetHolder) holder).m_AlphabetImage.setImageResource(m_AlphabetImages[position]);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(m_Context, Item.class);
            intent.putExtra("imageResource", m_AlphabetImages[position]);
            intent.putExtra("alphabet", m_Alphabets.get(position));
            intent.putExtra("description", m_AlphabetDescriptions[position]);

            m_Context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return m_Alphabets.size();
    }
}
