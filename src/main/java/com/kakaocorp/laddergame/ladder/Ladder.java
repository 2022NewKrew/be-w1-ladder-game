package com.kakaocorp.laddergame.ladder;

import java.util.List;
import java.util.Random;

public abstract class Ladder {

    final Random rand = new Random();

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

    public abstract boolean start();
    public abstract void makeLadder();
    public abstract void printLadder();

}
