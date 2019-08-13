package com.example.gameoflifemyapp.rules;

public class ThreeNeighbours implements Rule {
    private Boolean status;
    @Override
    public void checkRule(int neighbours) {
        status = null;
        if (neighbours == 3) {
            status = true;
        }
    }

    @Override
    public Boolean aliveStatus() {
        return status;
    }
}
