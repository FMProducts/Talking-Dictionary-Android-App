package com.fmproducts.rysgal.talkingdictionaryapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {
    @SerializedName("en")
    @Expose
    private String en;

    @SerializedName("tk")
    @Expose
    private String tk;

    @SerializedName("ru")
    @Expose
    private String ru;

    @SerializedName("transcription")
    @Expose
    private String transcription;

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getTk() {
        return tk;
    }

    public void setTk(String tk) {
        this.tk = tk;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }
}
