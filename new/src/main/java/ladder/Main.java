package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderConfig;
import ladder.domain.LadderGame;
import ladder.view.IO;


public class Main {
    public static void main(String[] args) {

        IO ioDriver = new IO();
        LadderConfig ladderConfig= ioDriver.getInput();
        Ladder ladder = new Ladder(ladderConfig);

        String ladderStr = ladder.getLadderStr();
        ioDriver.printLadder(ladderStr);

        run(ioDriver, ladder);

    }

    private static void run(IO ioDriver, Ladder ladder) {
        while (true){
            String resultUser = ioDriver.getResultsUser();
            String output=  ladder.runGame(resultUser);
            ioDriver.printResultEach(output);

        }


    }
}

