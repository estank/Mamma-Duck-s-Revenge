package com.example.myapplication;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {
    int a = 0;
    int b = 0;

    Bitmap background;

    Background (int screenA, int screenB, Resources res) {
        background = BitmapFactory.decodeResource(res,R.drawable.forest);
        background = Bitmap.createScaledBitmap(background,screenA,screenB,false);
    }
}
