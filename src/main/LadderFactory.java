package main;

public class LadderFactory {
    public static Ladder generateLadder(int peopleCount, int ladderHeight) {
        Ladder ladder = new Ladder(peopleCount, ladderHeight);
        for (int i = 0; i < ladder.getLadderHeight(); i++) {
            ladder.addLadderLine(new Line(peopleCount));
        }
        return ladder;
    }
}
