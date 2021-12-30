package step_4.view.output;

import step_4.domain.Ladder;
import step_4.domain.LadderCharacter;
import step_4.dto.LadderInfo;
import step_4.view.input.NameAndHeightInputInterface;

public class LadderAndNameOutputInterface implements OutputInterface {
    @Override
    public void print(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행결과\n");
        for (String name: ladderInfo.getNames()) {
            int numberOfLeftSpace = (NameAndHeightInputInterface.maxNameLength - name.length()) / 2;
            int numberOfRightSpace = numberOfLeftSpace + (NameAndHeightInputInterface.maxNameLength - name.length()) % 2;
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfLeftSpace));
            System.out.print(name);
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfRightSpace));
            System.out.print(LadderCharacter.ONE_SPACE.getValue());
        }
        System.out.print(LadderCharacter.CHANGE_LINE.getValue());

        ladder.printLadder();
    }
}
