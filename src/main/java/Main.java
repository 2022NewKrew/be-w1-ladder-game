import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        StartInfo startInfo = inputManager.getStartInfo();

        Ladder ladder = new Ladder(startInfo.getNumPeople(), startInfo.getMaxHeight());
        ladder.printLadder();
    }
}

