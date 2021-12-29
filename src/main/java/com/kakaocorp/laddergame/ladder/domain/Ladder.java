package com.kakaocorp.laddergame.ladder.domain;

import java.util.List;

public abstract class Ladder {

    int number;
    int height;
    List<Line> lines;

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

    public List<Line> getLines() {
        return lines;
    }

    public abstract boolean start();
    public abstract void makeLadder();

}
