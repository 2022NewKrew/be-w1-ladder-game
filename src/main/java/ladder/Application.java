package ladder;

import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.domain.Person;
import ladder.domain.Result;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 입력값 받기
        List<Person> people = InputView.inputPerson();
        int personCount = people.size();
        List<String> peopleNames = people.stream().map(Person::getName).collect(Collectors.toList());
        List<Result> results = InputView.inputResult();
        int ladderCount = InputView.inputLadderCount();

        // 사다리 만들기
        LadderController ladderController = new LadderController(ladderCount, personCount);
        Ladder ladder = ladderController.getLadder();

        // 사다리 출력하기
        OutputView.output(ladder, people, results);

        // 게임 전체 실행
        List<Integer> resultIndexList = new ArrayList<>();
        for (int i = 0; i < personCount; i++) {
            int resultIndex = ladder.playLadderGame(i);
            resultIndexList.add(resultIndex);
        }

        // 사용자 인터랙션
        while (true) {
            String resultPerson = InputView.inputResultPerson();
            if (resultPerson.equals("춘식이")) {
                break;
            }
            if (resultPerson.equals("all")) {
                OutputView.outputExecutionResult(people, results, resultIndexList);
            } else {
                int playerIndex = peopleNames.indexOf(resultPerson);
                OutputView.outputExecutionResult(results, resultIndexList.get(playerIndex));
            }
        }
    }
}
