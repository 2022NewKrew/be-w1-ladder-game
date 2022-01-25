package bin.jayden.ladder_game.domain;

import bin.jayden.ladder_game.exception.InvalidParticipantException;
import bin.jayden.ladder_game.view.LadderGamePrinter;
import bin.jayden.ladder_game.view.LadderGameScanner;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    public Ladder ladder;
    LadderGameInfo info;

    public void startLadderGame() {
        info = LadderGameScanner.getLadderInfo();

        ladder = new Ladder(info.getWidth(), info.getHeight());

        LadderGamePrinter.printGame(info, ladder);
        Map<String, String> resultMap = getResults(info);
        while (true) {
            System.out.println("\n결과를 보고 싶은 사람은?");
            String name = LadderGameScanner.getName();
            String result = getResult(resultMap, name);
            if (result == null) {
                break;
            }
            LadderGamePrinter.printResult(result);
        }
        System.out.println("\n게임을 종료합니다.");
    }

    private Map<String, String> getResults(LadderGameInfo info) {
        Map<String, String> resultMap = new HashMap<>();
        List<String> participants = info.getParticipants(), results = info.getResults();
        int width = info.getWidth(), height = info.getHeight();
        for (int i = 0; i < width; i++) {
            int resultIndex = getResultIndex(width - 1, height, i);
            resultMap.put(participants.get(i), results.get(resultIndex));
        }
        return Collections.unmodifiableMap(resultMap);
    }

    private int getResultIndex(int width, int height, int participantIndex) {
        int line = participantIndex;
        List<LadderRow> ladderRows = ladder.getLadderRows();
        for (int i = 0; i < height; i++) {
            if (line > 0 && ladderRows.get(i).getIsLine(line - 1))
                line--;
            else if (line < width && ladderRows.get(i).getIsLine(line))
                line++;

        }
        return line;
    }

    private String getResult(Map<String, String> resultMap, String name) throws InvalidParticipantException {

        try {
            switch (name) {
                case "춘식이":
                    return null;
                case "all":
                    return getAllResults(resultMap);
                default:
                    return getOneResult(resultMap, name);
            }
        } catch (InvalidParticipantException exception) {
            return exception.getMessage();
        }
    }

    private String getAllResults(Map<String, String> resultMap) {
        StringBuilder stringBuilder = new StringBuilder("\n실행 결과");
        info.getParticipants().forEach(participant -> stringBuilder.append(String.format("\n%s : %s", participant, resultMap.get(participant))));
        return stringBuilder.toString();
    }

    private String getOneResult(Map<String, String> resultMap, String name) throws InvalidParticipantException {
        if (!resultMap.containsKey(name))
            throw new InvalidParticipantException(Constants.INVALID_PARTICIPANT_MESSAGE);

        return String.format("\n실행 결과\n%s", resultMap.get(name));
    }

}
