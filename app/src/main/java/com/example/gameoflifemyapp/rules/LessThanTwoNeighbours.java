package com.example.gameoflifemyapp.rules;

public class LessThanTwoNeighbours implements Rule {
    private Boolean status;
    @Override
    public void checkRule(int neighbours) {
        status = null;
        if (neighbours < 2) {
            status = false;
        }
    }

    @Override
    public Boolean aliveStatus() {
        return status;
    }
}