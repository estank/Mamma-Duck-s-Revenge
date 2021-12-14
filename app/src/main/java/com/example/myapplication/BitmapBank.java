package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background;
    Bitmap player;
    Bitmap egg;
    Bitmap log;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.forest);
        player = BitmapFactory.decodeResource(res, R.drawable.duck_walking);
        egg = BitmapFactory.decodeResource(res, R.drawable.egg);
        log = BitmapFactory.decodeResource(res, R.drawable.log);
    }

    public Bitmap getBackground() {
        return background;
    }
    public int getBackgroundWidth() {
        return background.getWidth();
    }
    public int getBackgroundHeight() {
        return background.getHeight();
    }

    public Bitmap getPlayer() {
        return player;
    }
    public int getPlayerWidth() {
        return player.getWidth();
    }
    public int getPlayerHeight() {
        return player.getHeight();
    }

    public Bitmap getEgg() {
        return egg;
    }
    public int getEggWidth() {
        return egg.getWidth();
    }
    public int getEggHeight() {
        return egg.getHeight();
    }

    public Bitmap getLog() {
        return log;
    }
    public int getLogWidth() {
        return log.getWidth();
    }
    public int getLogHeight() {
        return log.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap) {
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        int backgroundScaleWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_WIDTH, true);
    }
}
