package LadderGame;

import java.util.*;

public class LadderGame {
    public static void main(String[] args) {
        GameManager mgr = GameManager.getMgr();
        mgr.setGame();
        mgr.printResult();

//        Ladder ladder = new Ladder();
//        ladder.inputLadderInfo();
//        ladder.makeLadder();
//        ladder.printLadder();
    }
}
