package main.domain;

public class LadderGameInput {
    private final String[] names;
    private final int heightOfLadder;

    public LadderGameInput(String[] names, int heightOfLadder) {
        this.names = names;
        this.heightOfLadder = heightOfLadder;
    }

    public String[] getNames() {
        return names;
    }

    public int getHeightOfLadder() {
        return heightOfLadder;
    }
}
