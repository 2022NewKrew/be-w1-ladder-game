package main;

import main.java.domain.Ladder;
import main.java.domain.LadderFactory;
import main.java.view.InputView;
import main.java.view.OutputView;

import java.util.*;

public class Main {
    // 자주 쓸 것 같은 애들은 밖에다 빼놓기
    static List<String> peopleNameList;
    static int ladderHeight;

    public static void main(String[] args) {
        peopleNameList = InputView.inputPeople();
        ladderHeight = InputView.inputLadderHeight();

        // ladder 생성
        Ladder ladder = LadderFactory.generateLadder(peopleNameList, ladderHeight);

        // ladder 출력
        OutputView.print(ladder);
    }
}
