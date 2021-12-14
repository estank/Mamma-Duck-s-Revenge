package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private boolean isPlaying;
    private int screenA;
    private int screenB;
    private float screenRatioA;
    private float screenRatioB;
    private Paint paint;

    private Background background1, background2;

    public GameView(Context context, int screenA, int screenB) {
        super(context);

        this.screenA = screenA;
        this.screenB = screenB;
        screenRatioA = 1920/screenA;
        screenRatioB = 1080/screenB;

        background1 = new Background(screenA,screenB, getResources());
        background2 = new Background(screenA,screenB, getResources());

        background2.a = screenA;

        paint = new Paint();
    }

    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }

    }

    private void update() {
        background1.a -= 10 * screenRatioA;
        background2.a -= 10 * screenRatioA;

        if (background1.a + background1.background.getWidth() < 0) {
            background1.a = screenA;
        }

        if (background2.a + background1.background.getWidth() < 0) {
            background2.a = screenA;
        }
    }

    private void draw() {

        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background, background1.a, background1.b, paint);
            canvas.drawBitmap(background2.background, background2.a, background2.b, paint);

            getHolder().unlockCanvasAndPost(canvas);

        }
    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}