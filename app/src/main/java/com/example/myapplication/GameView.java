package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;

public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback {

    private Thread thread;
    private boolean isPlaying;
    private int screenA;
    private int screenB;
    private float screenRatioA;
    private float screenRatioB;
    private Paint paint;

    GameThread gameThread;

    private Background background1, background2;

    public GameView(Context context) {
        super(context);
        initView();
    }

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

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(!gameThread.isRunning()) {
            gameThread = new GameThread(holder);
            gameThread.start();
        }
        else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        if(gameThread.isRunning()) {
            gameThread.setIsRunning(false);
            boolean retry = true;
            while(retry) {
                try {
                    gameThread.join();
                    retry = false;
                } catch (InterruptedException e) {

                }
            }
        }
    }

    public void initView() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN) {
            if(AppConstants.getGameEngine().gameState == 0) {
                AppConstants.getGameEngine().gameState = 1;
            }
            if(AppConstants.playerGrounded = true) {
                AppConstants.getGameEngine().player.setVelocity(AppConstants.VELOCITY_WHEN_JUMPED);
                AppConstants.playerGrounded = false;
            }
        }
        return true;
    }
}