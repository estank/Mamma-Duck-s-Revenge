package com.example.myapplication;

public class PlayerDead extends Player{
    public PlayerDead() {
        pX = AppConstants.SCREEN_WIDTH/3 - AppConstants.getBitmapBank().getPlayerWidth();
        pYInitial = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBackgroundHeight() - AppConstants.getBitmapBank().getPlayerHeight();
        pY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBackgroundHeight() - AppConstants.getBitmapBank().getPlayerHeight();
        pFrame = 0;
        velocity = 0;
    }
}
