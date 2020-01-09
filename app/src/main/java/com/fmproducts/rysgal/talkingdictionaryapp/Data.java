package com.fmproducts.rysgal.talkingdictionaryapp;

import android.content.res.AssetManager;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Data {

    private static String getFileText(AssetManager manager) throws IOException {
        InputStream stream = manager.open("data.json");
        int size = stream.available();
        byte[] buffer = new byte[size];
        stream.read(buffer);
        stream.close();
        return new String(buffer);
    }

    public static ArrayList<WordItem> getData(AssetManager manager) throws IOException {
        JsonModel model = new GsonBuilder().setLenient().excludeFieldsWithoutExposeAnnotation().create()
                .fromJson(getFileText(manager) , JsonModel.class);
        if (model == null) return new ArrayList<>();
        return model.getWordItems();
    }

    private class JsonModel{
        @SerializedName("words")
        @Expose
        private ArrayList<WordItem> wordItems;

        public ArrayList<WordItem> getWordItems() {
            return wordItems;
        }

        public void setWordItems(ArrayList<WordItem> wordItems) {
            this.wordItems = wordItems;
        }
    }
}
