package ladder.domain;

import ladder.view.IOController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    private static final String endCondition = "춘식이";
    private IOController io;
    private Ladder ladder;
    private int numOfPlayers, numOfLine;
    private List<FormattedString> playerList;
    private List<FormattedString> resultList;
    private Map<String, Integer> nameToIndex;

    public GameController() {
        io = new IOController();
        ladder = new Ladder();
    }

    public void startGame() throws IllegalArgumentException {
        inputParam();
        checkInputValues(numOfPlayers, numOfLine);
        mappingName();
        generateLadder();
        printLadder();
        executeResultCoroutine();
    }

    private void inputParam() {
        playerList = inputStringList("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        resultList = inputStringList("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        numOfLine = io.inputInt("최대 사다리 높이는 몇 개인가요?");
        numOfPlayers = playerList.size();
    }

    private void mappingName() {
        nameToIndex = new HashMap<>();
        for (int i = 0; i < playerList.size(); i++) {
            nameToIndex.put(playerList.get(i).getStr(), i);
        }
    }

    private void generateLadder() {
        ladder.setLadder(numOfPlayers, numOfLine);
    }

    private void printLadder() {
        List<LadderLine> currentLadder = ladder.getLadder();
        if (currentLadder == null) return;

        io.printLadder(currentLadder, playerList, resultList);
    }

    private void executeResultCoroutine() {
        String name = "";

        while (!name.equals(endCondition)) {
            name = io.inputString("결과를 보고 싶은 사람은?");
            System.out.println(getResult(name));
        }
    }

    private String getResult(String name) {
        if (name.equals("All")) {
            return getAllResult();
        }

        if (nameToIndex.get(name) == null) {
            return "존재하지 않는 유저입니다.";
        }

        return getResultByName(name);
    }

    private String getAllResult() {
        String key, value;
        StringBuilder sb = new StringBuilder();
        for (var player : playerList) {
            key = player.getStr();
            value = getResultByName(key);
            sb.append(String.format("%s : %s\n", key, value));
        }
        return sb.toString();
    }

    private String getResultByName(String name) {
        int startPos = nameToIndex.get(name);
        int resultIndex = ladder.getResult(startPos);
        return resultList.get(resultIndex).getStr();
    }

    private List<FormattedString> inputStringList(String msg) {
        List<FormattedString> strList = new ArrayList<>();
        for (var str : io.inputStringArray(msg)) {
            strList.add(new FormattedString(str));
        }

        return strList;
    }

    private void checkInputValues(int numOfPlayers, int numOfLine) throws IllegalArgumentException {
        validateNumOfLine(numOfLine);
        validateNumOfPlayers(numOfPlayers);
    }

    private void validateNumOfLine(int numOfLine) throws IllegalArgumentException {
        if (numOfLine <= 0)
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다.");
    }

    private void validateNumOfPlayers(int numOfPlayers) throws IllegalArgumentException {
        if (numOfPlayers <= 1)
            throw new IllegalArgumentException("플레이어가 두 명 이상이어야 합니다.");
    }
}
