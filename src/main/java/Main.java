import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        LadderGame game = new LadderGame(Input.inputCountOfPeople(),
                Input.inputLadderOfHeight());
        game.printWholeLadder();
    }
}

