package com.example.gameoflifemyapp.scoop;

import com.example.gameoflifemyapp.rules.LessThanTwoNeighbours;
import com.example.gameoflifemyapp.rules.MoreThanThreeNeighbours;
import com.example.gameoflifemyapp.rules.Rule;
import com.example.gameoflifemyapp.rules.ThreeNeighbours;

public class GameLogic implements DrawableGame {
    private GameField lastField;
    private Rule[] rules;

    public GameLogic(GameField gf) {
        this.lastField = gf;
    }

    public void createRuleSet() {
        createRuleSet(new ThreeNeighbours(), new LessThanTwoNeighbours(), new MoreThanThreeNeighbours());
    }

    public void createRuleSet(Rule... rules) {
        this.rules = rules;
    }

    public void simulateStep() {
        int height = lastField.getHeight();
        int width = lastField.getWidth();

        boolean[][] newField = new boolean[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                newField[y][x] = lastField.getCell(x, y).alive();
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int neighbours = checkNeighbours(x, y);
                //check Rules:
                for (Rule rule : rules) {
                    rule.checkRule(neighbours);
                    if (rule.aliveStatus() != null) {
                        newField[y][x] = rule.aliveStatus();
                    }
                }
            }
        }

        this.lastField = new LinearListGameField(newField);
    }

    private int checkNeighbours(int x, int y) {
        int count = 0;
        // von mitte gegen Uhrzeigersinn
        int[] xOff = {1, 1, 0, -1, -1, -1, 0, 1};
        int[] yOff = {0, 1, 1, 1, 0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            // use Modulo to get the neighbours outside of array range (check the other side instead)
            if (lastField.getCell((x + xOff[i] + lastField.getHeight()) % lastField.getHeight(), (y + yOff[i] + lastField.getWidth()) % lastField.getWidth()).alive()) {
                count++;
            }
        }
        return count;
    }

    public int getHeight() {
        return lastField.getHeight();
    }

    public int getWidth() {
        return lastField.getWidth();
    }

    public Cell getCell(int x, int y) {
        return lastField.getCell(x, y);
    }
}
