package com.fmproducts.rysgal.talkingdictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Sözlük");
        init();
    }
    private void init(){
        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);

        try {
            ArrayList<Word> data = Data.getData(this.getAssets());
            MainDictionaryAdapter adapter = new MainDictionaryAdapter(this , data);
            recyclerView.setAdapter(adapter);
        } catch (IOException e) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            if (e.getMessage() != null) Log.e(TAG , e.getMessage());
        }
    }



}
