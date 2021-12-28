public class LadderGame {
    public static void main(String[] args) {
        LadderFactory ladderFactory = new LadderFactory();
        Ladder ladder = ladderFactory.buildLadder();
        ladder.printLadder();
    }
}
