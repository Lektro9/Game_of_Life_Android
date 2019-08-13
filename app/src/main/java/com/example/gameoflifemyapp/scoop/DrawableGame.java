package com.example.gameoflifemyapp.scoop;

public interface DrawableGame {
    int getWidth();

    int getHeight();

    Cell getCell(int x, int y);
}
