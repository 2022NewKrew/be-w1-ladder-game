package view;

import domain.ConditionCheck;
import domain.Ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static domain.ConditionCheck.ESCAPE_WORD;
import static domain.ConditionCheck.MAX_NAME_LENGTH;

public class StandardInputLadderGameInputManager implements LadderGameInputManager {
    private final Scanner scan = new Scanner(System.in);

    @Override
    public String getString() {
        return scan.nextLine();
    }

    @Override
    public List<String> getParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요");
        List<String> participants = Arrays.asList(getString().split(","));

        if (!participants.isEmpty() && ConditionCheck.elementLengthCheck(participants)) {
            return Collections.unmodifiableList(participants);
        }

        System.out.println("잘못 입력하셨습니다!");
        System.out.println("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다." + System.lineSeparator());
        return getParticipants();
    }

    @Override
    public Ladder getLadder(List<String> participants) {
        return new Ladder(participants.size(), getHeight());
    }

    private int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        String height = getString();

        if(ConditionCheck.isPositiveInteger(height)) {
            return Integer.parseInt(height);
        }

        System.out.println("잘못 입력하셨습니다!");
        System.out.println("양의 정수만 입력해주세요" + System.lineSeparator());
        return getHeight();
    }

    @Override
    public List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요");
        List<String> results = Arrays.asList(getString().split(","));

        if (!results.isEmpty() && ConditionCheck.elementLengthCheck(results)) {
            return Collections.unmodifiableList(results);
        }

        System.out.println("잘못 입력하셨습니다!");
        System.out.println("결과는 " + MAX_NAME_LENGTH + "자 이하여야 합니다." + System.lineSeparator());
        return getResults();
    }

    @Override
    public String getRequest() {
        System.out.println(System.lineSeparator() + "결과를 보고 싶은 사람은?");
        String answer = getString();

        if(answer.equals(ESCAPE_WORD)) {
            System.out.println("게임을 종료합니다.");
            return null;
        }

        return answer;
    }
}
