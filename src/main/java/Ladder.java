package main.java;

public class Ladder {
    public static int height;
    public static String ladderLine;
    private String bridgeLine;

    Ladder() {
        bridgeLine = " ".repeat(height);
    }


    public static void initLadder(int ladderHeight) {
        if (ladderHeight > 0) {
            System.out.println(ladderHeight);
            height = ladderHeight;

            Ladder.ladderLine = "|".repeat(ladderHeight);
        }
    }

    public boolean isConnectedAt(int heightIdx) {
        return this.bridgeLine.charAt(heightIdx) == '-';
    }

    public void connectBridge(int heightIdx) {
        StringBuilder builder = new StringBuilder(bridgeLine);
        builder.setCharAt(heightIdx, '-');
        bridgeLine = builder.toString();
    }

    public String getBridgeLine() {
        return bridgeLine;
    }
}
