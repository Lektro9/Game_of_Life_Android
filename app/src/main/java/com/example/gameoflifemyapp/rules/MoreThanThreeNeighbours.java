package com.example.gameoflifemyapp.rules;

public class MoreThanThreeNeighbours implements Rule{
    private Boolean status;
    @Override
    public void checkRule(int neighbours) {
        status = null;
        if (neighbours > 3) {
            status = false;
        }
    }

    @Override
    public Boolean aliveStatus() {
        return status;
    }
}
