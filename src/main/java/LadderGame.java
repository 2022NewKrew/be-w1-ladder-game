public class LadderGame {
    public static void main(String[] args) {
        int peopleSize, height;

        peopleSize = InputHandler.getPeopleSize();
        height = InputHandler.getHeight();

        LadderFactory ladderFactory = new LadderFactory();
        Ladder ladder = ladderFactory.buildLadder(peopleSize, height);
        ladder.printLadder();
    }
}
