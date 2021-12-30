package kakao2022.david.sadari.step4.view;

import kakao2022.david.sadari.step4.domain.CheckName;
import kakao2022.david.sadari.step4.domain.Ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderUI {

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> inputPeople() {
        boolean isDone = false;
        List<String> peopleList = new ArrayList<>();
        while (!isDone) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            peopleList = Arrays.asList(scanner.next().split(","));
            isDone = CheckName.checkPeopleList(peopleList);
        }
        return peopleList;
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void printLadder(Ladder ladder) {
        System.out.println(ladder.getLadderInfo());
    }
}
