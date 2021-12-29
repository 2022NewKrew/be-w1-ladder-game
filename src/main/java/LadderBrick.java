package main.java;


import java.util.Random;

public class LadderBrick {
    private static final Random random = new Random();
    private final Line lineBridge;

    LadderBrick() {
        lineBridge = random.nextBoolean() ? Line.BRIDGE_CONNECTED : Line.BRIDGE_DISCONNECTED;
    }

    public Line getLineBridge() {
        return lineBridge;
    }
}

