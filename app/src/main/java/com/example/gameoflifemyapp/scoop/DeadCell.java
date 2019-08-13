package com.example.gameoflifemyapp.scoop;

public class DeadCell implements Cell {
    @Override
    public boolean alive() {
        return false;
    }
}
