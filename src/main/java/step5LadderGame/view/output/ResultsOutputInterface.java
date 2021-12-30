package step5LadderGame.view.output;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.exception.NotEqualSizeException;
import step2LadderGame.view.output.OutputInterface;
import step5LadderGame.domain.ladder.LadderIncludeParticipantsAndResults;

import java.util.List;

public class ResultsOutputInterface implements OutputInterface {

    public void print(Ladder ladder) {
        final LadderIncludeParticipantsAndResults ladderIncludeParticipantsAndResults = checkLadderType(ladder);

        final List<String> results = ladderIncludeParticipantsAndResults.getResults();

        System.out.println(resultsToString(results));
    }

    private LadderIncludeParticipantsAndResults checkLadderType(Ladder ladder) {
        if (!(ladder instanceof LadderIncludeParticipantsAndResults ladderIncludeParticipantsAndResults))
            throw new NotEqualSizeException();
        return ladderIncludeParticipantsAndResults;
    }

    private String resultsToString(List<String> results) {
        final StringBuilder sb = new StringBuilder();

        results.forEach(result -> appendFormattedResult(sb, result));

        return sb.toString();
    }

    private void appendFormattedResult(StringBuilder sb, String result) {
        final int maxSize = 6;

        final int preLength = (maxSize - result.length()) / 2;
        final int suffixLength = preLength + ((maxSize - result.length()) % 2);

        final String prefixSpace = " ".repeat(preLength);
        final String suffixSpace = " ".repeat(suffixLength);

        sb.append(prefixSpace).append(result).append(suffixSpace);
    }
}
