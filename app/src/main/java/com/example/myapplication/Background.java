package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {
    int a = 0;
    int b = 0;
    int velocity;

    Bitmap background;

    public Background() {
        a = 0;
        b = 0;
        velocity = 3;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getVelocity() {
        return velocity;
    }

    Background (int screenA, int screenB, Resources res) {
        background = BitmapFactory.decodeResource(res,R.drawable.forest);
        background = Bitmap.createScaledBitmap(background,screenA,screenB,false);
    }
}
