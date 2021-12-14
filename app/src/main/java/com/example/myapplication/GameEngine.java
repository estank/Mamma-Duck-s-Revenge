package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class GameEngine {
    Background backgroundImage;
    Player player;
    PlayerDead playerDead;
    Random random;
    int score;
    Paint scorePaint;
    int pFrame, pJFrame, pDFrame;
    static int gameState;
    Obstacles obstacles;
    Obstacles obstaclesLog;
    Bitmap obs;
    boolean obsSpawned;
    int points;
    final int TEXT_SIZE = 80;
    boolean collision = false;

    public GameEngine() {
        backgroundImage = new Background();
        player = new Player();
        playerDead = new PlayerDead();
        gameState = 0;
        obsSpawned = false;
        random = new Random();
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);
        obstacles = new Obstacles("");
        obstaclesLog = new Obstacles("Log");
        points = 0;
    }

   /* public void updateAndDrawBackgroundImage(Canvas canvas) {
        if(collision == false) {
            backgroundImage.setA(backgroundImage.getA() - backgroundImage.getVelocity());
            if(backgroundImage.getA() < AppConstants.getBitmapBank().getBackgroundWidth()) {
                backgroundImage.setA(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getA(), backgroundImage.getB(), null);
        if(backgroundImage.getA() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getA() + AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getB(), null);
        }
    }*/

    public void updateAndDrawPlayer (Canvas canvas) {
        if(gameState == 1) {
            if(collision == false && AppConstants.playerGrounded == false) {
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                player.setY(player.getY() + player.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerJump(pJFrame), player.getX(), player.getY(), null);
                pJFrame++;
                if(pJFrame > 3) {
                    pJFrame = 0;
                }
                if(player.getY() >= player.pYInitial) {
                    player.setY(player.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            }
            else if(collision == true && AppConstants.playerGrounded == false) {
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                player.setY(player.getY() + player.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), player.getX(), player.getY(), null);
                pDFrame++;
                if(pDFrame == 4) {
                    gameState = 2;
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
                if(playerDead.getY() >= playerDead.pYInitial){
                    playerDead.setY(playerDead.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            }
            else if(collision == false && AppConstants.playerGrounded) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(pFrame), player.getX(), player.getY(), null);
                pFrame++;
                if(pFrame > 3) {
                    pFrame = 0;
                }
            }
            else if(collision == true && AppConstants.playerGrounded) {
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayerDead(pDFrame), playerDead.getX(), playerDead.getY(), null);
                pDFrame++;
                if(pDFrame == 4) {
                    gameState = 2;
                    Context context = AppConstants.gameActivityContext;
                    Intent intent = new Intent(context, GameOver.class);
                    intent.putExtra("points", points);
                    context.startActivity(intent);
                    ((Activity) context).finish();
                }
            }
            if(obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPlayerWidth() && obstacles.cX + obstacles.width >= player.pX && obstacles.cY >= player.pY && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()) {
                collision = true;
                obstacles.reset();
            }
            canvas.drawText("Pt: " + points, 0, TEXT_SIZE, scorePaint);
        }
    }

    public void updateAndDrawObstacles(Canvas canvas){
        if(gameState == 1) {
            if(obsSpawned == false) {
                obstacles = obstaclesLog;
                obsSpawned = true;
            }
            if(collision == false) {
                obstacles.cX -= obstacles.velocity;
                if(obstacles.type.equalsIgnoreCase("Log")) {
                    obs = AppConstants.getBitmapBank().getLog();
                }
                canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
                if(obstacles.cX <= AppConstants.getBitmapBank().getLogWidth()) {
                    obstacles.reset();
                    points++;
                    obsSpawned = false;
                }
            }
        }
    }

    /*public void tapToStart(Canvas canvas) {
        if(AppConstants.getGameEngine().gameState == 0) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getTapToStart, AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getTapToStartWidth()/2, AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getTapToStartHeight()/2, null)
        }
    }*/
}
