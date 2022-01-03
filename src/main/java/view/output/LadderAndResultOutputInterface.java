package view.output;

import domain.Ladder;
import domain.LadderCharacter;
import dto.LadderInfo;
import view.input.NameAndResultInputInterface;

import java.util.Arrays;

import static view.input.NameAndResultInputInterface.inputNameforResult;

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
        System.out.println(ladder.getLadderResult(nameForResult));
        System.out.print(LadderCharacter.NEW_LINE.getValue());
        printNameResult(ladderInfo, ladder);
    }

    private void printAllNameResult(LadderInfo ladderInfo, Ladder ladder) {
        System.out.println("실행 결과");
        Arrays.stream(ladderInfo.getNames())
                .forEach(name -> {
                    System.out.printf("%s : %s\n", name, ladder.getLadderResult(name));
                });
        System.out.print(LadderCharacter.NEW_LINE.getValue());
        printNameResult(ladderInfo, ladder);
    }
}
