package com.kakao.view;

import com.kakao.domain.Ladder;
import com.kakao.domain.Line;
import com.kakao.domain.Mark;
import com.kakao.domain.Player;
import java.util.List;

public class OutputView {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    public OutputView() {}

    public void print(List<Player> players, Ladder ladder) {
        System.out.println("실행결과\n");
        printPlayers(players);
        printLadder(ladder);
    }

    private void printPlayers(List<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder
                .append(getName(player))
                .append(" ");
        }
        System.out.println(stringBuilder);
    }

    private String getName(Player player) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
            .append(BLANK.repeat((MAX_NAME_LENGTH - player.getNameLength()) / 2))
            .append(player.getName())
            .append(BLANK.repeat(MAX_NAME_LENGTH - stringBuilder.length()));
        return stringBuilder.toString();
    }

    private void printLadder(Ladder ladder) {
        for (Line line : ladder.getLines()) {
            printLine(line);
        }
    }

    private void printLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ");
        for (Boolean point : line.getPoints()) {
            stringBuilder
                .append(Mark.COL)
                .append(Mark.getMark(point));
        }
        stringBuilder.append(Mark.COL);
        System.out.println(stringBuilder);
    }
}
