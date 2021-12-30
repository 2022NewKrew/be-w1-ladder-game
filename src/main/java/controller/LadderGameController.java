package controller;

import controller.scanner.PositiveIntScanner;
import controller.scanner.StringArrayScanner;
import domain.Ladder;
import view.LadderView;

import java.util.ArrayList;

public class LadderGameController {
    private final int MAX_PLAYER_NAME_LENGTH = 5;
    private Ladder ladder;
    private final LadderView view = new LadderView();

    public void initializeLadderFromCli() {
        ArrayList<String> players = getPlayersFromCli();
        int maxHeight = getMaxHeightFromCli();
        ladder = new Ladder(players, maxHeight);
    }

    private ArrayList<String> getPlayersFromCli() {
        view.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        StringArrayScanner scanner = new StringArrayScanner();
        scanner.setMaxLength(MAX_PLAYER_NAME_LENGTH);
        return scanner.getValue();
    }

    private int getMaxHeightFromCli() {
        view.println("최대 사다리 높이는 몇 개인가요?");
        PositiveIntScanner scanner = new PositiveIntScanner();
        return scanner.getValue();
    }

    public void showLadder() {
        try {
            view.println(ladder.toStringBuilder(MAX_PLAYER_NAME_LENGTH));
        } catch (NullPointerException e) {
            view.println("Need to initialize Ladder object");
        }
    }
}
