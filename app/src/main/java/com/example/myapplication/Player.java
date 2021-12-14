package com.example.myapplication;

public class Player {
    public int pX, pY, pYInitial, velocity;

    public Player() {
        pX = AppConstants.SCREEN_WIDTH/3 - AppConstants.getBitmapBank().getPlayerWidth();
        pYInitial = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBackgroundHeight() - AppConstants.getBitmapBank().getPlayerHeight();
        pY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBackgroundHeight() - AppConstants.getBitmapBank().getPlayerHeight();
        velocity = 0;
    }

    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public int getX() {
        return pX;
    }
    public int getY() {
        return pY;
    }
    public void setY (int pY) {
        this.pY = pY;
    }
}
