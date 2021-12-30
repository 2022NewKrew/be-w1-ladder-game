package main.java.ladder.view;

import java.util.List;
import java.util.Scanner;

import static main.java.Application.sc;

public class LadderInput {
    private static final String DELIMITER = ",";

    private final List<String> players;
    private final List<String> results;
    private final int height;

    public LadderInput() {
        players = userInputStringList("참여할 사람 이름을 입력하세요. (이름은 쉼표로(,)로 구분하세요)");
        results = userInputStringList("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        validateLength();
        height = userInputHeight();
    }

    private List<String> userInputStringList(String expression) {
        System.out.println(expression);
        List<String> inputStringList = List.of(sc.nextLine().split(DELIMITER));

        validateStringList(inputStringList);
        return inputStringList;
    }

    private void validateStringList(List<String> inputStringList) {
        if (inputStringList.stream().anyMatch(str -> str.length() > 5)) {
            throw new IllegalArgumentException("문자열은 최대 5글자입니다.");
        }
    }

    private int userInputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int inputHeight = sc.nextInt();

        validateHeight(inputHeight);
        return inputHeight;
    }

    private void validateHeight(int inputHeight) {
        if (inputHeight < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1이상입니다.");
        }
    }

    private void validateLength() {
        if (players.size() != results.size()) {
            throw new IllegalArgumentException("참여할 사람과 실행 결과의 수는 같아야 합니다.");
        }
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getResults() {
        return results;
    }

    public int getHeight() {
        return height;
    }
}
