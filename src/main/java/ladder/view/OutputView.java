package ladder.view;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import ladder.dto.LadderDto;
import ladder.dto.LineDto;
import ladder.dto.PlayerDto;
import ladder.dto.PlayersDto;
import ladder.dto.InfoDto;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();
    private static final String WALL = "|";
    private static final String BLANK = "     ";
    private static final int MAX_NAME_SIZE = 5;
    private static final String HYPHEN = "-----";

    private OutputView() {
    }

    public static void printLadderInfo(InfoDto infoDto) {
        List<String> playerNames = infoDto.getPlayersDto()
            .getPlayerDtos()
            .stream()
            .map(PlayerDto::getName)
            .collect(Collectors.toList());

        printInputData(playerNames);
        printLadder(infoDto.getLadderDto());
        printInputData(infoDto.getRewardsDto().getRewards());
    }

    private static void printInputData(List<String> dates) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String date : dates) {
            stringBuilder.append(" ")
                .append(getBuffer(date))
                .append(date);
        }
        System.out.println(stringBuilder);
    }

    private static String getBuffer(String name) {
        return " ".repeat(Math.max(0, MAX_NAME_SIZE - name.length()));
    }

    public static void printLadder(LadderDto ladderDto) {
        for (LineDto lineDto : ladderDto.getLineDtos()) {
            printLine(lineDto);
        }
    }

    private static void printLine(LineDto lineDto) {
        final StringBuilder stringBuilder = new StringBuilder(WALL);
        System.out.print(BLANK);
        List<Boolean> points = lineDto.getPoints();
        for (int i = 0; i < points.size() - 1; i++) {
            stringBuilder.append(getSignature(points.get(i)))
                .append(WALL);
        }
        System.out.println(stringBuilder);
    }

    private static String getSignature(boolean point) {
        if (point) {
            return HYPHEN;
        }
        return BLANK;
    }

    public static void printResult(String reward) {
        System.out.println("실행 결과");
        System.out.println(reward);
        System.out.println();
    }

    public static void printBadInput() {
        System.out.println("존재하지 않는 유저입니다.");
        System.out.println();
    }

    public static void printResultAll(Map<String, String> results) {
        System.out.println("실행 결과");
        for (Entry<String, String> result : results.entrySet()) {
            System.out.printf("%s : %s%s", result.getKey(), result.getValue(), NEW_LINE);
        }
        System.out.println();
    }
}
