package com.example.gameoflifemyapp.scoop;

import android.os.Handler;

public class MyRunnable implements Runnable {
    private Handler handler;
    private int i;
    private AndroidGui androidGui;
    private GameLogic gl;
    private int cycleTime;

    public MyRunnable(Handler handler, AndroidGui androidGui, GameLogic gl, int cycleTime) {
        this.handler = handler;
        this.androidGui = androidGui;
        this.gl = gl;
        this.cycleTime = cycleTime;
    }

    @Override
    public void run() {
        this.handler.postDelayed(this, cycleTime);
        gl.simulateStep();
        androidGui.invalidate();
    }
}
