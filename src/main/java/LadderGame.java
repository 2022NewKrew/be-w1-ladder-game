import java.util.Scanner;

public class LadderGame {
    public static void main(String[] args) {
        Ladder ld = new Ladder(Input.getPlayerNames(), Input.getLadderHeight());
        ld.printLadder();
    }
}
