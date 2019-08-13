package com.example.gameoflifemyapp.scoop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class AndroidGui extends View {
    Paint paint = new Paint();
    private final DrawableGame game;
    private int gameFieldSizeModifier;

    public AndroidGui(Context context, DrawableGame game, int gameFieldSizeModifier) {
        super(context);
        this.game = game;
        this.gameFieldSizeModifier = gameFieldSizeModifier;
    }

    @Override
    public void onDraw(Canvas canvas) {

        for (int x = 0; x < game.getHeight(); x++) {
            for (int y = 0; y < game.getWidth(); y++) {
                float xCord = x + 10;
                float yCord = y + 10;
                float width = xCord + 1;
                float height = yCord + 1;
                if (game.getCell(x, y).alive()) {
                    paint.setAntiAlias(false);
                    paint.setColor(Color.BLACK);
                    paint.setStrokeWidth(1);
                    canvas.drawRect(xCord * gameFieldSizeModifier, yCord * gameFieldSizeModifier, width * gameFieldSizeModifier, height * gameFieldSizeModifier, paint);
                }
                if (!game.getCell(x, y).alive()) {
                    paint.setAntiAlias(false);
                    paint.setColor(Color.WHITE);
                    paint.setStrokeWidth(1);
                    canvas.drawRect(xCord * gameFieldSizeModifier, yCord * gameFieldSizeModifier, width * gameFieldSizeModifier, height * gameFieldSizeModifier, paint);
                }
            }
        }
    }

    public void show() {
        System.out.println("Android GUI starts");
    }

    public void update() {

    }
}

