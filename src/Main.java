import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        IO ioDriver = new IO();
        LadderConfig ladderConfig= ioDriver.getInput();
        Ladder ladder = new Ladder(ladderConfig);
        ioDriver.printLadder(ladder);

    }
}
