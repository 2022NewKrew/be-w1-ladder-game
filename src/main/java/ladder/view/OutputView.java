package ladder.view;

import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerDto;
import ladder.dto.PlayersDto;
import ladder.dto.ResultDto;

public class OutputView {

    private static final String WALL = "|";
    private static final String BLINK = "     ";
    private static final int MAX_NAME_SIZE = 5;

    private OutputView() {
    }

    public static void printResult(ResultDto resultDto) {
        printPlayer(resultDto.getPlayersDto());
        printLadder(resultDto.getLadderDto());
    }

    private static void printPlayer(PlayersDto playersDto) {
        StringBuilder stringBuilder = new StringBuilder();
        for (PlayerDto playerDto : playersDto.getPlayerDtos()) {
            stringBuilder.append(" ")
                .append(getBuffer(playerDto.getName()))
                .append(playerDto.getName());
        }
        System.out.println(stringBuilder);
    }

    private static String getBuffer(String name) {
        return " ".repeat(Math.max(0, MAX_NAME_SIZE - name.length()));
    }

    public static void printLadder(LadderDto ladderDto) {
        for (LineDto lineDto : ladderDto.getLineDtos()) {
            System.out.print(BLINK);
            printLine(lineDto);
        }
    }

    private static void printLine(LineDto lineDto) {
        final StringBuilder stringBuilder = new StringBuilder(WALL);
        for (boolean point : lineDto.getPoints()) {
            stringBuilder.append(getSignature(point))
                .append(WALL);
        }
        System.out.println(stringBuilder);
    }

    private static String getSignature(boolean point) {
        if (point) {
            return "-----";
        }
        return BLINK;
    }
}
