package step5LadderGame.view.output;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.exception.NotEqualSizeException;
import step2LadderGame.util.consoleInput.StringInputConsole;
import step2LadderGame.view.output.OutputInterface;
import step5LadderGame.domain.ladder.LadderIncludeParticipantsAndResults;

import java.util.Optional;

public class MatchingResultOutputInterface implements OutputInterface {

    @Override
    public void print(Ladder ladder) {
        final StringInputConsole stringInputConsole = new StringInputConsole();

        String participant = stringInputConsole.read("결과를 보고 싶은 사람은?");
        while (isNotEndPoint(participant)) {
            System.out.println("실행 결과\n" + getMatchingResultString(ladder, participant));
            participant = stringInputConsole.read("결과를 보고 싶은 사람은?");
        }

        System.out.println("게임을 종료합니다.");
    }

    private boolean isNotEndPoint(String participant) {
        return participant.hashCode() != "춘식이".hashCode();
    }

    private String getMatchingResultString(Ladder ladder, String participant) {
        final LadderIncludeParticipantsAndResults ladderIncludeParticipantsAndResults = checkLadderType(ladder);

        final boolean isAll = participant.hashCode() == "all".hashCode();
        if (isAll) {
            return getAllMatchingResults(ladderIncludeParticipantsAndResults);
        }

        return getMatchingResult(ladderIncludeParticipantsAndResults, participant);
    }

    private String getAllMatchingResults(LadderIncludeParticipantsAndResults ladder) {
        final StringBuilder sb = new StringBuilder();

        ladder.getParticipants()
                .forEach(participant -> appendMatchingResult(sb, participant, getMatchingResult(ladder, participant)));

        return sb.toString();
    }

    private String getMatchingResult(LadderIncludeParticipantsAndResults ladder, String participant) {
        final Optional<String> matchingResult = ladder.getMatchingResult(participant);

        return matchingResult.isEmpty() ? "참석하지 않은 유저 입니다." : matchingResult.get();
    }

    private void appendMatchingResult(StringBuilder sb, String participant, String result) {
        sb.append(participant)
                .append(" : ")
                .append(result)
                .append("\n");
    }

    private LadderIncludeParticipantsAndResults checkLadderType(Ladder ladder) {
        if (!(ladder instanceof LadderIncludeParticipantsAndResults ladderIncludeParticipantsAndResults))
            throw new NotEqualSizeException();
        return ladderIncludeParticipantsAndResults;
    }
}
