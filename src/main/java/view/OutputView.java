package view;

import config.LadderGameConfig;
import exception.NoSuchNameException;
import input.InputManager;
import ladder.Ladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class OutputView {

    public static void show(Ladder ladder) {
        ladder.print();
        getInputAndShowResults(ladder);
    }

    //Map<> 으로 결과 갖다놓
    private static void getInputAndShowResults(Ladder ladder) {
        String next = getInput();
        Map<String, String> results = getResult(ladder);
        if (checkEndCondition(next)) return;
        do {
            validateName(results, next);
            showResult(results, next);
            next = getInput();
        } while (!checkEndCondition(next));
    }

    private static void validateName(Map<String, String> results, String next) {
        if(!results.containsKey(next) && !next.equals(LadderGameConfig.ALL_CONDITION.getValue()) && !next.equals(LadderGameConfig.END_CONDITION.getValue()))
            throw new NoSuchNameException("그런 이름을 가진 참여자는 없습니다.");
    }

    private static Map<String, String> getResult(Ladder ladder) {
        Map<String, String> resultsMap = new HashMap<>();
        List<String> resultAll = LadderResultFinder.getResultAll(ladder);
        List<String> participants = ladder.getParticipants();
        IntStream.range(0, resultAll.size()).forEach(i -> resultsMap.put(participants.get(i) ,resultAll.get(i)));
        return resultsMap;
    }

    private static void showResult(Map<String, String> results, String next) {
        if (next.equals("all")) {
            showResultAll(results);
            return;
        }
        showSingleResult(results.get(next));
    }

    private static void showResultAll(Map<String, String> results) {
        results.keySet().stream().forEach(i -> System.out.println(i + ":" + results.get(i)));
        System.out.println();
    }

    private static void showSingleResult(String result) {
        System.out.println(result);
        System.out.println();
    }

    private static Boolean checkEndCondition(String str) {
        if (str.equals("춘식이")) {
            System.out.println("게임을 종료합니다.");
            return true;
        }
        return false;
    }

    private static String getInput() {
        System.out.println("결과를 보고싶은 사람은?");
        String inputValue = InputManager.nextLine();
        return inputValue;
    }
}
