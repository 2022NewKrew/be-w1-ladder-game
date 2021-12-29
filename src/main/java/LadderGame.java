public class LadderGame {
    public static void main(String[] args) {
        int peopleSize, height;

        peopleSize = InputHandler.getPeopleSize();
        height = InputHandler.getHeight();

        Ladder ladder = LadderFactory.buildLadder(peopleSize, height);

        OutputHandler.printLadder(ladder);
    }
}
