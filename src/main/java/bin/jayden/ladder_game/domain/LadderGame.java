package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.view.LadderGamePrinter;
import bin.jayden.ladder_game.view.LadderInfoScanner;

public class LadderGame {

    private LadderGame() {
        //instance 생성 제한용 생성자
    }

    public static void startLadderGame() {
        LadderInfo info = null;
        while (info == null) //입력을 제대로 받을때까지 반복해서 입력을 받는다.
            info = LadderInfoScanner.getLadderInfo();
        Ladder ladder = new Ladder(info.getWidth(), info.getHeight());
        LadderGamePrinter.printGame(ladder, info);
    }
}
