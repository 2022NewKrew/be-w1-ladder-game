package com.kakaocorp.laddergame.ladder;

import java.util.ArrayList;
import java.util.List;

public abstract class Ladder {

    int number;
    int height;
    List<String> ladder;

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    int getHeight() {
        return height;
    }

    void setHeight(int height) {
        this.height = height;
    }

    public abstract void start();
    public abstract void makeLadder();
    public abstract void printLadder();

}
