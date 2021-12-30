package bin.jayden.ladder_game.view;

import bin.jayden.ladder_game.domain.*;
import bin.jayden.ladder_game.exception.InvalidParticipantException;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LadderGamePrinter {
    private final Ladder ladder;
    private final LadderGameInfo info;
    private final Map<String, String> resultMap;

    public LadderGamePrinter(Ladder ladder, LadderGameInfo info, Map<String, String> resultMap) {
        this.ladder = ladder;
        this.info = info;
        this.resultMap = Collections.unmodifiableMap(resultMap);
    }

    private static void printLine(boolean isLine) {
        char ladderCharacter = isLine ? Constants.LADDER_LINE_CHARACTER : Constants.LADDER_EMPTY_CHARACTER;
        for (int i = 0; i < Constants.MAX_NAME_SIZE; i++)
            System.out.print(ladderCharacter);
        System.out.print(Constants.LADDER_SEPARATION_CHARACTER);
    }

    public void printGame() {
        System.out.print(listToFormattedString(info.getParticipants()));
        printLadder(ladder);
        System.out.println("\n" + listToFormattedString(info.getResults()));
    }

    public boolean printResult() {
        String result;
        try {
            System.out.println("\n결과를 보고 싶은 사람은?");
            String name = LadderGame.scanner.nextLine();
            result = getResult(name);
        } catch (InvalidParticipantException exception) {
            result = exception.getMessage();
        }
        if (result != null)
            System.out.println(result);

        return result != null;
    }

    public String getResult(String name) throws InvalidParticipantException {
        switch (name) {
            case "춘식이":
                return null;
            case "all":
                return getAllResults();
            default:
                return getOneResult(name);
        }
    }

    public String getAllResults() {
        StringBuilder stringBuilder = new StringBuilder("\n실행 결과");
        info.getParticipants().forEach(participant -> stringBuilder.append(String.format("\n%s : %s", participant, resultMap.get(participant))));
        return stringBuilder.toString();
    }

    public String getOneResult(String name) throws InvalidParticipantException {
        if (!resultMap.containsKey(name))
            throw new InvalidParticipantException();

        return String.format("\n실행 결과\n%s", resultMap.get(name));
    }

    private String listToFormattedString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();

        list.forEach(element -> stringBuilder.append(String.format("%" + Constants.MAX_NAME_SIZE + "s ", element)));
        return stringBuilder.toString();
    }

    private void printLadder(Ladder ladder) {
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (LadderRow row : ladderRows) {
            System.out.printf("\n%" + Constants.PREFIX_SIZE + "s", "|");
            row.getRow().forEach(LadderGamePrinter::printLine);
        }
    }
}
