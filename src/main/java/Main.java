import Ladder.IOManager.InputManager;
import Ladder.Ladder;

public class Main {
    public static void main(String[] args) {
        Ladder ladder = new Ladder(InputManager.getInputDTO());
        ladder.printLadder();
    }
}