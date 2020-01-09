package com.fmproducts.rysgal.talkingdictionaryapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WordItem {
    @SerializedName("word")
    @Expose
    private Word word;
    @SerializedName("file")
    @Expose
    private String file;

    public String getName(int language) {
        switch (language){
            case 1: /* en */ return word.getEn();
            case 2: /* ru */ return word.getRu();
            default: return word.getTk();
        }
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
