package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap background;
    Bitmap[] player = new Bitmap[4];
    Bitmap[] playerJump = new Bitmap[4];
    Bitmap[] playerDead = new Bitmap[4];
    Bitmap egg;
    Bitmap log;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.forest);

        player[0] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_1);
        player[1] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_2);
        player[2] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_3);
        player[3] = BitmapFactory.decodeResource(res, R.drawable.duck_wlak_4);

        playerJump[0] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_1);
        playerJump[1] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_2);
        playerJump[2] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_3);
        playerJump[3] = BitmapFactory.decodeResource(res, R.drawable.duck_wlak_4);

        playerDead[0] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_1);
        playerDead[1] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_2);
        playerDead[2] = BitmapFactory.decodeResource(res, R.drawable.duck_walk_3);
        playerDead[3] = BitmapFactory.decodeResource(res, R.drawable.duck_wlak_4);

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

    public Bitmap getPlayer(int pFrame) {
        return player[pFrame];
    }
    public int getPlayerWidth() {
        return player[0].getWidth();
    }
    public int getPlayerHeight() {
        return player[0].getHeight();
    }

    public Bitmap getPlayerJump(int pFrame) {
        return player[pFrame];
    }

    public Bitmap getPlayerDead(int pFrame) {
        return player[pFrame];
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
