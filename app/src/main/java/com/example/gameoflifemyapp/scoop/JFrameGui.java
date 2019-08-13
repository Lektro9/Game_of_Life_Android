/*package com.example.gameoflifemyapp.scoop;

import javax.swing.*;
import java.awt.*;

public class JFrameGui implements Gui {
    private final DrawableGame game;
    private JFrame frame;
    private int gameFieldSizeModifier;

    public JFrameGui(int x, int y, DrawableGame game, int gameFieldSizeModifier) {
        this.game = game;
        this.frame = new JFrame();
        this.gameFieldSizeModifier = gameFieldSizeModifier;
        //frame.setLocationRelativeTo(null);
        frame.setLocation(800,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((game.getWidth() * gameFieldSizeModifier) + 15, (game.getHeight() * gameFieldSizeModifier) + 40);
        frame.setTitle("Game of Life");
    }

    @Override
    public void show() {
        System.out.println("JFrame GUI starts");
        frame.setVisible(true);
    }

    @Override
    public void update() {
        JLabel label = new JLabel() {
            public void paint(Graphics g) {
                for (int x = 0; x <game.getHeight(); x++) {
                    for (int y = 0; y < game.getWidth(); y++) {
                        if (game.getCell(x,y).alive()) {
                            g.setColor(Color.BLACK);
                            g.fillRect(x * gameFieldSizeModifier, y * gameFieldSizeModifier, gameFieldSizeModifier, gameFieldSizeModifier);
                            //g.drawRect(x*4, y*4, 4, 4);

                        }
                        if (!game.getCell(x,y).alive()) {
                            g.setColor(Color.WHITE);
                            //g.fillRect(x*4, y*4, 4, 4);
                            g.drawRect(x * gameFieldSizeModifier, y * gameFieldSizeModifier, gameFieldSizeModifier, gameFieldSizeModifier);
                        }
                    }
                }
            }
        };
        frame.add(label);
        frame.repaint();
    }
}*/
