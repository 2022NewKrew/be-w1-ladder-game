package preproces;

import dto.LadderInputInfo;
import service.LadderCharacter;

import java.util.ArrayList;
import java.util.List;

public class NameInputPreprocessor implements InputPreprocessor {
    @Override
    public void inputPreProcessing(LadderInputInfo ladderInputInfo) {
        List<String> participantsNames = ladderInputInfo.getParticipantsNames();
        List<String> preprocessedParticipantsNames = putPrefixAndSuffixOnName(participantsNames);
        ladderInputInfo.setParticipantsNamesAfterPreprocessing(preprocessedParticipantsNames);
    }


    private List<String> putPrefixAndSuffixOnName(List<String> participantsNamesWithoutSpace) {
        StringBuilder nameWithSpace = new StringBuilder();
        List<String> participantsName = new ArrayList<>();
        for (String nameWithoutSpace : participantsNamesWithoutSpace) {
            int nameLength = nameWithoutSpace.length();
            nameWithSpace.append(calculatePrefix(nameLength)).append(nameWithoutSpace).append(calculateSuffix(nameLength));
            participantsName.add(nameWithSpace.toString());
            nameWithSpace.setLength(0);
        }
        return participantsName;
    }

    private String calculateSuffix(int nameLength) {
        if (nameLength == 5) {
            return LadderCharacter.EMPTY;
        }
        return nameLength == 1 ? LadderCharacter.TWO_SPACE : LadderCharacter.SPACE;
    }

    private String calculatePrefix(int nameLength) {
        if (nameLength == 5 || nameLength == 4) {
            return LadderCharacter.EMPTY;
        }
        return nameLength == 1 || nameLength == 2 ? LadderCharacter.TWO_SPACE : LadderCharacter.SPACE;
    }
}
