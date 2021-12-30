package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.view.LadderGamePrinter;
import bin.jayden.ladder_game.view.LadderInfoScanner;

public class LadderGame {

    private LadderGame() {
        //instance 생성 제한용 생성자
    }

    public static void startLadderGame() {
        LadderInfo info = LadderInfoScanner.getLadderInfo();
        Ladder ladder = new Ladder(info);
        LadderGamePrinter.printGame(ladder, info);
    }
}
