package game.ladder;

import java.util.ArrayList;
import java.util.Random;

public class LadderWhole {
    // 사다리 출력 모양 지정을 위한 상수
    private static final String LADDER_LINE = "|";
    private static final String LADDER_BRIDGE = "-";
    private static final String LADDER_EMPTY = " ";
    private static final int NAME_SPACE = 5;

    private final Integer heightOfLadder;
    private final Integer numOfPlayer;
    private final ArrayList<String> playerNameArrayList;
    private final ArrayList<LadderLine> ladderLineArrayList;

    // 생성자
    public LadderWhole(Integer heightOfLadder, Integer numOfPlayer, ArrayList<String> playerNameArrayList) {
        this.heightOfLadder = heightOfLadder;
        this.numOfPlayer = numOfPlayer;
        this.playerNameArrayList = playerNameArrayList;
        this.ladderLineArrayList = makeLines();
    }

    // 사다리 Lines 들을 만들과 ladderLineArrayList 에 저장한다.
    public ArrayList<LadderLine> makeLines() {
        ArrayList<LadderLine> result = new ArrayList<>();
        // 사다리 라인 객체를 만들고 저장한다. 일단 모두 꽝이다.
        for (int i = 0; i < numOfPlayer; i++) {
            result.add(new LadderLine(heightOfLadder));
        }
        return result;
    }

    // 사다리를 무작위로 연결한다.
    public void makeRandomBridgesAll() {
        Random random = new Random();
        // 라인 0 ~ numOfPlayer - 2 까지 순회한다.
        for (int i = 0; i < numOfPlayer - 1; i++) {
            LadderLine leftLine = ladderLineArrayList.get(i);
            LadderLine rightLine = ladderLineArrayList.get(i + 1);
            makeRandomBridgesTwoLines(leftLine, rightLine, random);
        }
    }

    // 사다리의 두 Line 을 무작위로 연결한다.
    private void makeRandomBridgesTwoLines(LadderLine leftLine, LadderLine rightLine, Random random) {
        ArrayList<LadderJoint> leftLineJoints = leftLine.getLadderJointArrayList();
        ArrayList<LadderJoint> rightLineJoints = rightLine.getLadderJointArrayList();
        LadderJoint leftJoint, rightJoint;
        for (int i = 0; i < heightOfLadder; i++) {
            leftJoint = leftLineJoints.get(i);
            rightJoint = rightLineJoints.get(i);
            checkBridgePossibilityAndConnect(leftJoint, rightJoint, random);
        }
    }

    // 난수 결과가 true 이고, 두 joint 가 어디에도 연결되어 있지 않을 때 새로 연결
    // 난수 결과가 true 이고, 앞선 joint 에 연결이 있더라도 추가난수의 결과가 true 이면 연결(확률을 맞추기 위해)
    private void checkBridgePossibilityAndConnect(LadderJoint leftJoint, LadderJoint rightJoint, Random random) {
        boolean randomBoolean = random.nextBoolean();
        // 난수 결과가 true 이고, 두 joint 가 어디에도 연결되어 있지 않을 때 새로 연결
        if (randomBoolean && leftJoint.getLeftOrRightJoint() == null && rightJoint.getLeftOrRightJoint() == null) {
            leftJoint.connectSideJoint(rightJoint);
            rightJoint.connectSideJoint(leftJoint);
            return;
        }
        // 난수 결과가 true 이고, 앞선 joint 에 연결이 있더라도 추가난수의 결과가 true 이면 연결(확률을 맞추기 위해)
        if (randomBoolean && leftJoint.getLeftOrRightJoint() != null) {
            leftJoint.getLeftOrRightJoint().connectSideJoint(null);
            leftJoint.connectSideJoint(rightJoint);
            rightJoint.connectSideJoint(leftJoint);
        }
    }

    // 사다리 출력 String 을 만든다.
    public String printLadder() {
        StringBuilder sb = new StringBuilder();
        // 플레이어 출력
        sb.append("\n");
        for (String name : playerNameArrayList) {
            sb.append(" ".repeat((NAME_SPACE - name.length() + 1) / 2));
            sb.append(name);
            sb.append(" ".repeat((NAME_SPACE - name.length()) / 2));
            sb.append(" ");
        }
        sb.append("\n");

        // 각 층 출력
        for (int i = 0; i < heightOfLadder; i++) {
            printOneFloor(sb, i);
        }
        return sb.toString();
    }

    private void printOneFloor(StringBuilder sb, Integer height) {
        sb.append(" ".repeat(NAME_SPACE / 2));
        // 각 라인을 순회하면서 height 층을 그린다.
        for (int i = 0; i < numOfPlayer - 1; i++) {
            LadderJoint leftJoint = ladderLineArrayList.get(i).getLadderJointArrayList().get(height);
            LadderJoint rightJoint = ladderLineArrayList.get(i + 1).getLadderJointArrayList().get(height);
            sb.append(LADDER_LINE);
            sb.append(LADDER_BRIDGE.repeat((leftJoint.getLeftOrRightJoint() == rightJoint) ? NAME_SPACE : 0));
            sb.append(LADDER_EMPTY.repeat((leftJoint.getLeftOrRightJoint() == rightJoint) ? 0 : NAME_SPACE));
        }
        sb.append(LADDER_LINE);
        sb.append("\n");
    }

    public ArrayList<LadderLine> getLadderLineArrayList() {
        return ladderLineArrayList;
    }
}
