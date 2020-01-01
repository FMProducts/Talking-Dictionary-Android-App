package com.fmproducts.rysgal.talkingdictionaryapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class MainDictionaryAdapter extends RecyclerView.Adapter<MainDictionaryAdapter.ViewHolder> {

    private static final String TAG = "MainDictionaryAdapter";

    private Player player;
    private ArrayList<Word> data;
    private LayoutInflater inflater;

    public MainDictionaryAdapter(Context context, ArrayList<Word> data) {
        this.player = Player.getInstance(context.getAssets());
        this.data = data;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.word_item , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = data.get(position);

        holder.word.setText(word.getName());
        holder.content.setOnClickListener(v->{
            try {
//                player.pause();
                player.play(word.getFile());
            } catch (IOException e) {
                Toast.makeText(v.getContext(), "error", Toast.LENGTH_SHORT).show();
                if (e.getMessage() != null) Log.e(TAG , e.getMessage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private RelativeLayout content;
        private AppCompatTextView word;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.content);
            word = itemView.findViewById(R.id.word);
        }
    }
}
