package step3LadderGame.view.output;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.exception.ladderException.TypeMissMatchException;
import step2LadderGame.view.output.OutputInterface;
import step3LadderGame.domain.ladder.LadderIncludeParticipants;

import java.util.List;

public class ParticipantsOutputInterface implements OutputInterface {

    public void print(Ladder ladder) {
        final LadderIncludeParticipants ladderIncludeParticipants = checkLadderType(ladder);

        final List<String> nameList = ladderIncludeParticipants.getParticipants();

        System.out.println(nameListToString(nameList));
    }

    private LadderIncludeParticipants checkLadderType(Ladder ladder) {
        if (!(ladder instanceof LadderIncludeParticipants ladderIncludeParticipants))
            throw new TypeMissMatchException();
        return ladderIncludeParticipants;
    }

    private String nameListToString(List<String> nameList) {
        final StringBuilder sb = new StringBuilder();

        nameList.forEach(name -> appendFormattedName(sb, name));

        return sb.toString();
    }

    private void appendFormattedName(StringBuilder sb, String name) {
        final int maxSize = 6;

        final int preLength = (maxSize - name.length()) / 2;
        final int suffixLength = preLength + ((maxSize - name.length()) % 2);

        final String prefixSpace = " ".repeat(preLength);
        final String suffixSpace = " ".repeat(suffixLength);

        sb.append(prefixSpace).append(name).append(suffixSpace);
    }
}
