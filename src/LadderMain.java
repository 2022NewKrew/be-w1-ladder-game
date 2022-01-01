import java.util.List;

public class LadderMain {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        List<String> namesOfPeople = LadderUI.getNamesOfPeople();
        int numOfPeople = namesOfPeople.size();
        int height = LadderUI.getHeight();

        Ladder ladder = new Ladder(numOfPeople, height);

        LadderUI.printNamesAndLadder(namesOfPeople, ladder);
    }
}
