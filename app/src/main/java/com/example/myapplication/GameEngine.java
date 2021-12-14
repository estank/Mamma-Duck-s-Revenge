package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    Background backgroundImage;
    Player player;
    Random random;
    int score;
    Paint scorePaint;
    static int gameState;
    ArrayList<Obstacles> obstaclesList;
    Obstacles obstacles;
    Bitmap obs;
    boolean obsSpawned;
    int points;
    final int TEXT_SIZE = 80;
    boolean collision = false;

    public GameEngine() {
        backgroundImage = new Background();
        player = new Player();
    }
}
