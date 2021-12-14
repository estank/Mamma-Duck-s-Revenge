package com.example.myapplication;

import java.util.Random;

public class Obstacles {
    public int cX, cY;
    public String type;
    public int velocity;
    public int width;
    Random random;

    public Obstacles(String type) {
        this.type = type;
        cX = AppConstants.SCREEN_WIDTH + 1000;
        cY = AppConstants.SCREEN_HEIGHT;
        random = new Random();
        if(type.equalsIgnoreCase("Log")) {
            cY -= AppConstants.getBitmapBank().getLogHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getLogWidth();
        }
    }

    public void reset() {
        cX = AppConstants.SCREEN_WIDTH + 300;
        if(type.equalsIgnoreCase("Log")) {
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);
        }
    }
}
