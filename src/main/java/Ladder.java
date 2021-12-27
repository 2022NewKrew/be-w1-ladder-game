package main.java;

public class Ladder {
    public static int height;
    public static String ladderLine;
    private boolean lastLadder = false;
    private String bridgeLine;

    Ladder(){
        StringBuilder builder = new StringBuilder();
        builder.append(" ".repeat(height));
        bridgeLine = builder.toString();
    }


    public static void initLadder(int ladderHeight){
        if(ladderHeight> 0 ) {
            System.out.println(ladderHeight);
            height = ladderHeight;

            StringBuilder builder = new StringBuilder();
            builder.append("|".repeat(ladderHeight));
            Ladder.ladderLine = builder.toString();
        }
    }

    public boolean isConnectedAt(int heightIdx){
        return this.bridgeLine.charAt(heightIdx) == '-';
    }

    public void connectBridge(int heightIdx){
        StringBuilder builder = new StringBuilder(bridgeLine);
        builder.setCharAt(heightIdx, '-');
        bridgeLine = builder.toString();
    }

    public boolean isLastLadder() {
        return lastLadder;
    }

    public void setLastLadder(boolean lastLadder) {
        this.lastLadder = lastLadder;
    }

    public String getBridgeLine() {
        return bridgeLine;
    }
}
