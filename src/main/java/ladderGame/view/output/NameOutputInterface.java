package ladderGame.view.output;

import ladderGame.domain.ladder.Ladder;
import ladderGame.domain.ladder.LadderIncludeNames;
import ladderGame.exception.ladderException.TypeMissMatchException;

import java.util.List;

public class NameOutputInterface implements OutputInterface {
    public void print(Ladder ladder) {
        final LadderIncludeNames ladderIncludeNames = checkLadderType(ladder);

        final List<String> nameList = ladderIncludeNames.getNameList();

        System.out.println(nameListToString(nameList));
    }

    private LadderIncludeNames checkLadderType(Ladder ladder) {
        if (!(ladder instanceof LadderIncludeNames ladderIncludeNames))
            throw new TypeMissMatchException();
        return ladderIncludeNames;
    }

    private String nameListToString(List<String> nameList) {
        final int maxSize = 5;

        final StringBuilder sb = new StringBuilder();
        nameList.forEach(name -> {

            final String suffixSpace = " ".repeat((maxSize - name.length()) / 2 + (maxSize - name.length()) % 2);
            final String prefixSpace = " ".repeat((maxSize - name.length()) / 2 + (maxSize - name.length()) % 2);

            sb.append(suffixSpace)
                    .append(name)
                    .append(prefixSpace);
        });

        return sb.toString();
    }
}
