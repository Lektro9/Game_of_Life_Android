package com.example.gameoflifemyapp.scoop;

public interface  GameField {

    int getHeight();

    int getWidth();

    Cell getCell(int x, int y);
}
