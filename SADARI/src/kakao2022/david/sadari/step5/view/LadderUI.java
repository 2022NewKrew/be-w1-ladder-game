package kakao2022.david.sadari.step5.view;

import kakao2022.david.sadari.step5.domain.CheckName;
import kakao2022.david.sadari.step5.domain.Ladder;

import java.util.*;

public class LadderUI {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String ALL = "all";
    private static final String END = "춘식이";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String END_MESSAGE = "\n게임을 종료합니다.";

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

    public List<String> inputResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼(,)로 구분하세요)");
        return Arrays.asList(scanner.next().split(","));
    }

    public void printLadder(Ladder ladder) {
        System.out.println("사다리 결과");
        System.out.println(ladder.getLadderInfo());
        System.out.println();
    }

    public void printGameResult(HashMap<String, String> gameResult) {
        boolean isDone = false;
        while (!isDone) {
            System.out.println("결과를 보고 싶은 사람은?");
            String person = scanner.next();
            isDone = printResult(person, gameResult);
            System.out.println();
        }
    }

    private boolean printResult(String person, HashMap<String, String> gameResult) {
        if (person.equals(END)) {
            System.out.println(END_MESSAGE);
            return true;
        }
        System.out.println(RESULT_MESSAGE);
        if (person.equals(ALL)) {
            printAllResult(gameResult);
            return false;
        }
        printPersonResult(person, gameResult);
        return false;
    }

    private void printPersonResult(String person, HashMap<String, String> gameResult) {
        System.out.println(person + " : " + gameResult.get(person));
    }

    private void printAllResult(HashMap<String, String> gameResult) {
        for (String person : gameResult.keySet()) {
            printPersonResult(person, gameResult);
        }
    }
}
