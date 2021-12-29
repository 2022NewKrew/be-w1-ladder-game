import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        List<String> people;
        int height;

        InputHandler inputHandler = new InputHandler();
        OutputHandler outputHandler = new OutputHandler();

        people = inputHandler.getPeople();
        height = inputHandler.getHeight();

        Ladder ladder = LadderFactory.buildLadder(people.size(), height);

        outputHandler.printPeople(people);
        outputHandler.printLadder(ladder);
    }
}
