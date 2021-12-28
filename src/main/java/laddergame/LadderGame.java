package laddergame;

public class LadderGame {
    private final int numberOfGamer;
    private final int maxHeight;
    private final Ladder ladder;

    public LadderGame(int numberOfGamer, int maxHeight) {
        this.numberOfGamer = numberOfGamer;
        this.maxHeight = maxHeight;
        this.ladder = new Ladder(numberOfGamer, maxHeight);
    }

    public void printLadder() {
        for (String line : ladder) {
            System.out.println(line);
        }
    }
}
