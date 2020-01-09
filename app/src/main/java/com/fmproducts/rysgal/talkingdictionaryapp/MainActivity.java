package com.fmproducts.rysgal.talkingdictionaryapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
//farizmamedow
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MainDictionaryAdapter adapter;

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
            ArrayList<WordItem> data = Data.getData(this.getAssets());
            adapter = new MainDictionaryAdapter(this , data);
            recyclerView.setAdapter(adapter);
        } catch (IOException e) {
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            if (e.getMessage() != null) Log.e(TAG , e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_item){
            new AlertDialog.Builder(this)
                    .setCancelable(true)
                    .setItems(R.array.languages , (dialog, which)->{
                        if (adapter != null) adapter.setLanguage(which+1);
                    }).show();
            return true;
        }
        return false;
    }
}