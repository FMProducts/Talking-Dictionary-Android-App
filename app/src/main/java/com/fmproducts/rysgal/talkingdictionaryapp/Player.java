package com.fmproducts.rysgal.talkingdictionaryapp;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;

public class Player {
    private static Player instance;

    public static Player getInstance(AssetManager manager) {
        if (instance == null) instance = new Player(manager);
        return instance;
    }

    private MediaPlayer player;
    private AssetManager manager;
    private Player(AssetManager manager){
        this.player = new MediaPlayer();
        this.manager = manager;
    }

    void play(String filename) throws IOException {
        player.reset();
        AssetFileDescriptor descriptor = manager.openFd("sound/"+filename);
        Log.e("Player" , "sound/"+filename);
        player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
        player.setOnPreparedListener(MediaPlayer::start);
        player.prepareAsync();
    }
}
