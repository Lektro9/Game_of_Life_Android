package com.example.gameoflifemyapp.scoop;

import java.util.ArrayList;
import java.util.List;

public class LinearListGameField implements GameField {
    private final int width;
    private final int height;
    private final List<Cell> cells;

    public LinearListGameField(int width, int height, List<Cell> cells) {
        this.width = width;
        this.height = height;
        this.cells = cells;
    }

    public LinearListGameField(int height, int width, int probabilityInPercent) {
        boolean[][] field = new boolean[height][width];
        this.width = field.length;
        this.height = field[0].length;
        cells = new ArrayList<>();

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                if ((int)(Math.random() * 100) < probabilityInPercent) {
                    cells.add(new LivingCell());
                } else {
                    cells.add(new DeadCell());
                }
            }
        }
    }

    public LinearListGameField(boolean[][] field) {
        cells = new ArrayList<>();

        this.width = field.length;
        this.height = field[0].length;

        for (int y = 0; y < field.length; y++) {
            for (int x = 0; x < field.length; x++) {
                cells.add(field[y][x] ? new LivingCell() : new DeadCell());
            }
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public Cell getCell(int x, int y) {
        return cells.get(x + y * width);
    }
}
