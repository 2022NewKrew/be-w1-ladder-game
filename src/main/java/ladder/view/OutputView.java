package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Person;
import ladder.domain.Result;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String STICK = "|";
    private static final String EXISTED_BRIDGE = "-----";
    private static final String NOT_EXISTED_BRIDGE = "     ";
    private static final int MAX_LENGTH_OF_NAME = 5;
    private static final int MAX_LENGTH_OF_CONTENT = 5;

    public static void output(Ladder ladder, List<Person> people, List<Result> results) {
        System.out.println("사다리 결과");
        System.out.println();
        OutputView.outputPerson(people);
        OutputView.outputLadder(ladder);
        OutputView.outputResult(results);
    }

    private static void outputLadder(Ladder ladder) {
        List<Line> lines = ladder.getLines();
        for (Line line : lines) {
            outputLine(line);
            System.out.println();
        }
    }

    private static void outputLine(Line line) {
        System.out.print("  ");
        System.out.print(STICK);
        for (boolean bridge : line.getBridges()) {
            String outputBridge = bridge ? EXISTED_BRIDGE : NOT_EXISTED_BRIDGE;
            System.out.print(outputBridge);
            System.out.print(STICK);
        }
    }

    private static void outputPerson(List<Person> people) {
        StringBuilder sb = new StringBuilder();
        for (Person person : people) {
            String name = person.getName();
            int totalSpaceNum = MAX_LENGTH_OF_NAME - name.length();
            int leftSpaceNum = totalSpaceNum / 2;
            int rightSpaceNum = totalSpaceNum - leftSpaceNum;
            sb.append(makeSpace(leftSpaceNum)).append(name).append(makeSpace(rightSpaceNum)).append(" ");
        }
        System.out.println(sb);
    }

    private static void outputResult(List<Result> results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            String name = result.getContent();
            int totalSpaceNum = MAX_LENGTH_OF_CONTENT - name.length();
            int leftSpaceNum = totalSpaceNum / 2;
            int rightSpaceNum = totalSpaceNum - leftSpaceNum;
            sb.append(makeSpace(leftSpaceNum)).append(name).append(makeSpace(rightSpaceNum)).append(" ");
        }
        System.out.println(sb);
    }

    private static String makeSpace(int spaceNum) {
        return " ".repeat(Math.max(0, spaceNum));
    }

    public static void outputExecutionResult(List<Result> results, int resultIndex) {
        System.out.println("실행 결과");
        System.out.println(results.get(resultIndex).getContent());

    }

    public static void outputExecutionResult(List<Person> people, List<Result> results, List<Integer> resultIndexList) {
        System.out.println("실행 결과");
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i).getName() + " : " + results.get(resultIndexList.get(i)).getContent());
        }
    }
}
