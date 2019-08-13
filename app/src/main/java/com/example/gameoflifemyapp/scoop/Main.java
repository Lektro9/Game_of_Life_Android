package com.example.gameoflifemyapp.scoop;


public class Main {
    public static void main(String[] args) {
        GameField gf = new LinearListGameField(400, 400, 20);

        GameLogic gl = new GameLogic(gf);

        Gui gui = new ConsoleGui(gl);
        /*Math.random() > 1.5
                ? new ConsoleGui(gl)
                : new JFrameGui(600, 800, gl, 2);*/

        gui.show();
        gui.update();
        gl.createRuleSet();

        for (int i = 0; i < 1000; i++) {
            gl.simulateStep();

            gui.update();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
