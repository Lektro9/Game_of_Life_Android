package com.example.gameoflifemyapp.scoop;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class GoLActivity extends AppCompatActivity {




    AndroidGui androidGui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get the values of last act.:
        Bundle extras = getIntent().getExtras();
        int height = extras.getInt("height");
        int probability = extras.getInt("probability");
        int sizeMod = extras.getInt("sizeMod");
        int cycleTime = extras.getInt("cycleTime");

        System.out.println(sizeMod);

        GameField gf = new LinearListGameField(height, height, probability);
        GameLogic gl = new GameLogic(gf);
        androidGui = new AndroidGui(this, gl, sizeMod);
        gl.createRuleSet();
        androidGui.setBackgroundColor(Color.WHITE);

        setContentView(androidGui);

        gl.simulateStep();
        final Handler handler = new Handler();
        handler.post(new MyRunnable(handler, androidGui, gl, cycleTime));
    }
}
