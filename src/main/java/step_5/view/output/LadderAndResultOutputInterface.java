package step_5.view.output;

import step_5.domain.Ladder;
import step_5.domain.LadderCharacter;
import step_5.dto.LadderInfo;
import step_5.view.input.NameAndResultInputInterface;

import java.util.Arrays;

import static step_5.view.input.NameAndResultInputInterface.inputNameforResult;

public class LadderAndResultOutputInterface implements OutputInterface {
    @Override
    public void print(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("사다리 결과\n");
        printNames(ladderInfo);
        printLadder(ladder);
        printResult(ladderInfo);
        System.out.print(LadderCharacter.NEW_LINE.getValue());
        printNameResult(ladderInfo, ladder);

        System.out.println("게임을 종료합니다.");
        System.out.print(LadderCharacter.NEW_LINE.getValue());
    }

    private void printNames(LadderInfo ladderInfo) {
        for (String name: ladderInfo.getNames()) {
            int numberOfLeftSpace = (NameAndResultInputInterface.maxNameLength - name.length()) / 2;
            int numberOfRightSpace = numberOfLeftSpace + (NameAndResultInputInterface.maxNameLength - name.length()) % 2;
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfLeftSpace));
            System.out.print(name);
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfRightSpace));
            System.out.print(LadderCharacter.ONE_SPACE.getValue());
        }
        System.out.print(LadderCharacter.NEW_LINE.getValue());
    }

    private void printLadder(Ladder ladder) {
        ladder.printLadder();
    }

    private void printResult(LadderInfo ladderInfo) {
        for (String result: ladderInfo.getResults()) {
            int numberOfLeftSpace = (NameAndResultInputInterface.maxNameLength - result.length()) / 2;
            int numberOfRightSpace = numberOfLeftSpace + (NameAndResultInputInterface.maxNameLength - result.length()) % 2;
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfLeftSpace));
            System.out.print(result);
            System.out.print(LadderCharacter.ONE_SPACE.getValue().repeat(numberOfRightSpace));
            System.out.print(LadderCharacter.ONE_SPACE.getValue());
        }
        System.out.print(LadderCharacter.NEW_LINE.getValue());
    }

    private void printNameResult(LadderInfo ladderInfo, Ladder ladder) {
        String nameForResult = inputNameforResult(ladderInfo);

        if (nameForResult.equals(NameAndResultInputInterface.finisher)) {
            return;
        }

        if (nameForResult.equals("all")) {
            printAllNameResult(ladderInfo, ladder);
            return;
        }

        System.out.println("실행 결과");
        int indexOfNameForResult = Arrays.asList(ladderInfo.getNames()).indexOf(nameForResult);
        int resultOfNameForResult = ladder.getLadderResult(indexOfNameForResult);
        System.out.println(ladderInfo.getResults()[resultOfNameForResult]);
        System.out.print(LadderCharacter.NEW_LINE.getValue());
        printNameResult(ladderInfo, ladder);
    }

    private void printAllNameResult(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행 결과");
        for (String name: ladderInfo.getNames()) {
            int indexOfNameForResult = Arrays.asList(ladderInfo.getNames()).indexOf(name);
            int resultOfNameForResult = ladder.getLadderResult(indexOfNameForResult);
            System.out.printf("%s : %s\n", name, ladderInfo.getResults()[resultOfNameForResult]);
        }
        System.out.print(LadderCharacter.NEW_LINE.getValue());
        printNameResult(ladderInfo, ladder);
    }
}
