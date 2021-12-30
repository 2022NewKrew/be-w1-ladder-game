package com.kakao.domain.ladder;

import com.kakao.domain.player.Player;
import java.util.List;

public class LadderPrinter {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int OPERAND = 2;
    private static final String BLANK = " ";

    public String generatePlayerNames(List<Player> players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players) {
            stringBuilder
                .append(player.getRefinedName())
                .append(BLANK);
        }
        return stringBuilder.toString();
    }

    public String generateLadder(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Line line : ladder.getLines()) {
            stringBuilder
                .append(generateLine(line))
                .append("\n");
        }
        return stringBuilder.toString();
    }

    private StringBuilder generateLine(Line line) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BLANK.repeat(MAX_NAME_LENGTH / OPERAND));
        for (Boolean point : line.getPoints()) {
            stringBuilder
                .append(Mark.COL)
                .append(Mark.of(point));
        }
        stringBuilder.append(Mark.COL);
        return stringBuilder;
    }
}
