package output;

import service.domain.Ladder;
import service.LadderCharacter;
import service.LadderSizeConfig;
import service.domain.LadderLine;
import service.domain.LadderPlayResultInputStr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommandLineOutputController implements OutputController {
    @Override
    public void outputLadder(Ladder ladder) {
        String nameLine = buildNameLine(ladder.getParticipantsNames());
        System.out.println(nameLine);
        List<String> outPutLadder = buildOutputLadder(ladder.getLadder());
        outPutLadder.forEach(System.out::println);
        String resultLine = buildResultLine(ladder.getGameResultsLine());
        System.out.println(resultLine);
    }

    @Override
    public void outputResult(Map<String, Integer> playLadderGameResult, List<String> gameResultsLine, String result) {
        if (result.equals(LadderPlayResultInputStr.ALL)) {
            printAllResults(playLadderGameResult, gameResultsLine);
            return;
        }
        System.out.println("실행 결과");
        System.out.println(gameResultsLine.get(playLadderGameResult.get(result)));
    }

    @Override
    public void outputEndingComment() {
        System.out.println("게임을 종료합니다.");
    }

    private void printAllResults(Map<String, Integer> playLadderGameResult, List<String> gameResultsLine) {
        StringBuilder resultsBuilder = new StringBuilder();
        for (String participantName : playLadderGameResult.keySet()) {
            String result = gameResultsLine.get(playLadderGameResult.get(participantName));
            resultsBuilder.append(participantName).append(" : ").append(result);
            System.out.println(resultsBuilder);
            resultsBuilder.setLength(0);
        }
    }

    private List<String> buildOutputLadder(List<LadderLine> ladder) {
        List<String> outPutLadder = new ArrayList<>();
        for (LadderLine ladderLine : ladder) {
            outPutLadder.add(buildOutputLadderLine(ladderLine));
        }
        return outPutLadder;
    }

    private String buildOutputLadderLine(LadderLine ladderLine) {
        StringBuilder ladderLineStrBuilder = new StringBuilder(LadderCharacter.FIRST_COLUMN);
        List<Boolean> isLadderConnected = ladderLine.getIsLadderConnected();
        for (Boolean isConnected : isLadderConnected) {
            String connection = isConnected ? LadderCharacter.CONNECTED : LadderCharacter.NOT_CONNECTED;
            ladderLineStrBuilder.append(connection).append(LadderCharacter.COLUMN);
        }
        return ladderLineStrBuilder.toString();
    }

    private String buildResultLine(List<String> gameResultsLine) {
        StringBuilder resultLine = new StringBuilder();
        for (String gameResult : gameResultsLine) {
            int gameResultLength = gameResult.length();
            resultLine.append(padLeft(gameResultLength))
                    .append(gameResult)
                    .append(padLeft(gameResultLength))
                    .append(LadderCharacter.SPACE);
        }
        return resultLine.toString();
    }

    private String buildNameLine(List<String> participantsNames) {
        StringBuilder nameLine = new StringBuilder(LadderCharacter.NEWLINE);
        for (String participantName : participantsNames) {
            int nameLength = participantName.length();
            nameLine.append(padRight(nameLength))
                    .append(participantName)
                    .append(padLeft(nameLength))
                    .append(LadderCharacter.SPACE);
        }
        return nameLine.toString();
    }

    /**
     * suffix를 계산하는 식: (LADDER_CONNECTION_LENGTH - NAME(RESULT)_LENGTH)/2 + (LADDER_CONNECTION_LENGTH - NAME(RESULT)_LENGTH) % 2
     */
    private String padLeft(int nameLength) {
        int numberOfSpace = (LadderSizeConfig.LADDER_CONNECTION_LENGTH - nameLength) / 2;
        return LadderCharacter.SUFFIX.repeat(Math.max(0, numberOfSpace));
    }

    /**
     * prefix를 계산하는 식: (LADDER_CONNECTION_LENGTH - NAME(RESULT)_LENGTH) / 2
     */
    private String padRight(int nameLength) {
        int numberOfSpace = (LadderSizeConfig.LADDER_CONNECTION_LENGTH - nameLength) / 2 + (LadderSizeConfig.LADDER_CONNECTION_LENGTH - nameLength) % 2;
        return LadderCharacter.PREFIX.repeat(Math.max(0, numberOfSpace));
    }

}
