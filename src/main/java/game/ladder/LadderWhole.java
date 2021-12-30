package game.ladder;

import game.ladder.Utils.LadderJointsContainer;
import game.ladder.Utils.LadderLinesContainer;
import game.ladder.Utils.PlayerNameContainer;

import java.util.*;

public class LadderWhole {
    // 사다리 출력 모양 지정을 위한 상수
    private static final String LADDER_LINE = "|";
    private static final String LADDER_BRIDGE = "-";
    private static final String LADDER_EMPTY = " ";
    private static final int NAME_SPACE = 5;

    private final Integer heightOfLadder;
    private final Integer numOfPlayer;
    private final PlayerNameContainer playerNameContainer;
    private final LadderLinesContainer ladderLinesContainer;

    private final Random random = new Random();

    // 생성자
    public LadderWhole(Integer heightOfLadder, Integer numOfPlayer, ArrayList<String> playerNameArrayList, ArrayList<String> resultList) {
        this.heightOfLadder = heightOfLadder;
        this.numOfPlayer = numOfPlayer;
        this.playerNameContainer = new PlayerNameContainer(playerNameArrayList);
        this.ladderLinesContainer = makeLines(resultList);
    }

    // 사다리 Lines 들을 만들과 ladderLineArrayList 에 저장한다.
    public LadderLinesContainer makeLines(ArrayList<String> resultList) {
        ArrayList<LadderLine> result = new ArrayList<>();
        // 사다리 라인 객체를 만들고 저장한다. 일단 모두 꽝이다.
        for (int i = 0; i < numOfPlayer; i++) {
            result.add(new LadderLine(heightOfLadder, resultList.get(i)));
        }
        return new LadderLinesContainer(result);
    }

    // 사다리를 무작위로 연결한다.
    public void makeRandomBridgesAll() {
        // 라인 0 ~ numOfPlayer - 2 까지 순회한다.
        for (int i = 0; i < numOfPlayer - 1; i++) {
            LadderLine leftLine = ladderLinesContainer.get(i);
            LadderLine rightLine = ladderLinesContainer.get(i + 1);
            makeRandomBridgesTwoLines(leftLine, rightLine);
        }
    }

    // 사다리의 두 Line 을 무작위로 연결한다.
    private void makeRandomBridgesTwoLines(LadderLine leftLine, LadderLine rightLine) {
        LadderJointsContainer leftLineJoints = leftLine.getLadderJointsContainer();
        LadderJointsContainer rightLineJoints = rightLine.getLadderJointsContainer();
        LadderJoint leftJoint, rightJoint;
        for (int i = 0; i < heightOfLadder; i++) {
            leftJoint = leftLineJoints.get(i);
            rightJoint = rightLineJoints.get(i);
            checkBridgePossibilityAndConnect(leftJoint, rightJoint);
        }
    }

    // 난수 결과가 true 이고, 두 joint 가 어디에도 연결되어 있지 않을 때 새로 연결
    private void checkBridgePossibilityAndConnect(LadderJoint leftJoint, LadderJoint rightJoint) {
        // 난수 결과가 true 이고, 두 joint 가 어디에도 연결되어 있지 않을 때 새로 연결
        if (!random.nextBoolean()) {
            return;
        }
        if (leftJoint.getLeftOrRightJoint() == null) {
            doJointConnect(leftJoint, rightJoint);
            return;
        }
        // 난수 결과가 true 이고, 앞선 joint 에 연결이 있더라도 추가난수의 결과가 true 이면 연결(확률을 맞추기 위해)
        if (!random.nextBoolean()) {
            return;
        }
        leftJoint.getLeftOrRightJoint().connectSideJoint(null);
        doJointConnect(leftJoint, rightJoint);
    }

    private void doJointConnect(LadderJoint leftJoint, LadderJoint rightJoint) {
        leftJoint.connectSideJoint(rightJoint);
        rightJoint.connectSideJoint(leftJoint);
    }

    // 사다리 출력 String 을 만든다.
    public String printLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n사다리 결과\n");
        // 플레이어 출력
        sb.append("\n");
        for (String name : playerNameContainer) {
            printString(sb, name);
        }
        sb.append("\n");
        // 각 층 출력
        for (int i = 0; i < heightOfLadder; i++) {
            printOneFloor(sb, i);
        }
        // 결과 출력
        for (LadderLine ladderLine : ladderLinesContainer) {
            printString(sb, ladderLine.getResult());
        }
        sb.append("\n");
        return sb.toString();
    }

    private void printString(StringBuilder sb, String str) {
            sb.append(" ".repeat((NAME_SPACE - str.length() + 1) / 2));
            sb.append(str);
            sb.append(" ".repeat((NAME_SPACE - str.length()) / 2));
            sb.append(" ");
    }


    private void printOneFloor(StringBuilder sb, Integer height) {
        sb.append(" ".repeat(NAME_SPACE / 2));
        // 각 라인을 순회하면서 height 층을 그린다.
        for (int i = 0; i < numOfPlayer - 1; i++) {
            LadderJoint leftJoint = ladderLinesContainer.get(i).getLadderJointsContainer().get(height);
            LadderJoint rightJoint = ladderLinesContainer.get(i + 1).getLadderJointsContainer().get(height);
            sb.append(LADDER_LINE);
            sb.append(LADDER_BRIDGE.repeat((leftJoint.getLeftOrRightJoint() == rightJoint) ? NAME_SPACE : 0));
            sb.append(LADDER_EMPTY.repeat((leftJoint.getLeftOrRightJoint() == rightJoint) ? 0 : NAME_SPACE));
        }
        sb.append(LADDER_LINE);
        sb.append("\n");
    }

    public LadderLinesContainer getLadderLinesContainer() {
        return ladderLinesContainer;
    }

    public String getResultByPlayerName(String name){
        StringBuilder sb = new StringBuilder();
        if (Objects.equals(name, "all")){
            // 전원 출력
            sb.append("실행 결과");
            allResultOfLines(sb);
            return sb.toString();
        }
        int index = playerNameContainer.getIndexOfPlayerByName(name);
        if (index == -1) {
            return "존재하지 않는 사람입니다.";
        }
        // index 라인에서 시작할 때 결과값을 받아서 sb에 넣는다.
        sb.append(findResultOfJoint(ladderLinesContainer.get(index).getResultIfStartThisLine()));
        return sb.toString();
    }

    private void allResultOfLines(StringBuilder sb) {
        for (int i = 0; i< numOfPlayer; i++){
            sb.append("\n");
            sb.append(playerNameContainer.get(i));
            sb.append(" : ");
            sb.append(findResultOfJoint(ladderLinesContainer.get(i).getResultIfStartThisLine()));
        }
    }


    private String findResultOfJoint(LadderJoint joint) {
        for (LadderLine line : ladderLinesContainer) {
            if (line.getLadderJointsContainer().get(heightOfLadder-1) == joint){
                return line.getResult();
            }
        }
        return "error!";
    }
}
