package output;

import dto.Ladder;
import service.LadderCharacter;
import service.LadderSizeConfig;

import java.util.List;

public class CommandLineOutputController implements OutputController {
    @Override
    public void outputLadder(Ladder ladder) {
        List<String> participantsNames = ladder.getParticipantsNames();
        StringBuilder nameLine = new StringBuilder("\n");
        for (String participantsName : participantsNames) {
            int nameLength = participantsName.length();
            nameLine.append(calculatePrefix(nameLength)).append(participantsName).append(calculateSuffix(nameLength)).append(LadderCharacter.SPACE);
        }
        System.out.print(nameLine);
        System.out.println(ladder);
    }

    /**
     *  (5-n)/2 + (5-n)%2suffix를 계산하는 식입니다. 5는 사다리의 width입니다.
     */
    private String calculateSuffix(int nameLength) {
        int numberOfSpace = (LadderSizeConfig.LADDER_WIDTH - nameLength) / 2;
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < numberOfSpace; i++){
            suffix.append(LadderCharacter.SUFFIX);
        }
        return suffix.toString();
    }

    /**
     *  (5-n)/2 prefix를 계산하는 식입니다. 5는 사다리의 width입니다.
     */
    private String calculatePrefix(int nameLength) {
        int numberOfSpace = (LadderSizeConfig.LADDER_WIDTH - nameLength) / 2 + (LadderSizeConfig.LADDER_WIDTH - nameLength) % 2;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < numberOfSpace; i++){
            prefix.append(LadderCharacter.PREFIX);
        }
        return prefix.toString();
    }

}
