import java.util.Scanner;

public class LadderGame {

    public static void main(String[] args) {
        InputController inputController = new InputController();
        LadderGenerator ladderGenerator = new NormalLadderGenerator();
        printLadder(inputController, ladderGenerator);
    }

    private static void printLadder(InputController inputController, LadderGenerator ladderGenerator) {
        int heights = inputController.getHeights();
        int noParticipants = inputController.getNoParticipants();
        Ladder ladder = ladderGenerator.buildLadder(heights, noParticipants);
        System.out.println(ladder);
    }
}
