package com.example.gameoflifemyapp.scoop;

public class ConsoleGui implements Gui {
    private final DrawableGame game;

    public ConsoleGui(DrawableGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        System.out.println("Game starts");
    }

    @Override
    public void update() {
        int height = game.getHeight();
        int width = game.getWidth();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Cell c = game.getCell(x, y);

                System.out.print(c.alive() ? "o " : "x ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
