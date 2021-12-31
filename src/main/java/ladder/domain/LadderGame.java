package ladder.domain;

import ladder.view.Input;

import java.io.IOException;

public class LadderGame {
    // 상수
    private final String LADDER_QUESTION = "결과를 보고 싶은 사람은?";
    private final String EXIT = "춘식이";
    private final String LADDER_EXIT = "게임을 종료합니다.";

    // 인스턴스 변수
    private final Input input;
    private final Ladder ladder;

    // 생성자
    public LadderGame (Input input, Ladder ladder) {
        this.input = input;
        this.ladder = ladder;
    }

    // 메서드
    public void playLadderGame () throws IOException{
        boolean flag = true;
        while (flag) {
            String person = input.input("\n" + LADDER_QUESTION);
            flag = getLadderResult(person);
        }
    }

    private boolean getLadderResult(String person) {
        if (person.equals(EXIT)) {
            System.out.println("\n" + LADDER_EXIT);
            return false;
        }

        System.out.println(ladder.playLadder(person));
        return true;
    }
}
