package main.java;


import java.util.Random;

public class LadderBrick {
    private final char lineLadder = '|';
    private final LineBridge lineBridge;

    LadderBrick(){
        Random random = new Random();
        lineBridge = random.nextBoolean() ? LineBridge.CONNECTED : LineBridge.DISCONNECTED;
    }

    @Override
    public String toString() {
        return "" + lineLadder + lineBridge.line;
    }
}

