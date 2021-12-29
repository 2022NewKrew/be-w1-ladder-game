public class LadderGame {
    public static void main(String[] args) {
        int peopleSize, height;

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        peopleSize = inputHandler.getPeopleSize();
        height = inputHandler.getHeight();

        Ladder ladder = LadderFactory.buildLadder(peopleSize, height);

        outputHandler.printLadder(ladder);
    }
}
