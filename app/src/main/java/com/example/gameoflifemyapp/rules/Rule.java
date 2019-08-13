package com.example.gameoflifemyapp.rules;

public interface Rule {
    void checkRule(int neighbours);
    Boolean aliveStatus();
}
