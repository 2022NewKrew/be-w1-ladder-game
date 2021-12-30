package game.ladder;

import game.ladder.Utils.LadderJointsContainer;

import java.util.ArrayList;
import java.util.Collections;

public class LadderLine {
    private final Integer height;
    private final LadderJointsContainer ladderJointsContainer;
    private final String result;

    public LadderLine(Integer height, String result) {
        this.height = height;
        this.ladderJointsContainer = makeJointsAndDownConnect(height);
        this.result = result;
    }

    // Line 에 포함된 Joint 들을 만들고 아래로 내려가는 참조 필드를 연결시킨다.
    private LadderJointsContainer makeJointsAndDownConnect(int height) {
        ArrayList<LadderJoint> result = new ArrayList<>(height);
        LadderJoint presentJoint;
        LadderJoint downerJoint = null;
        for (int i = this.height - 1; i >= 0; i--) {
            presentJoint = new LadderJoint();
            presentJoint.connectDownJoint(downerJoint);
            result.add(presentJoint);
            downerJoint = presentJoint;
        }
        // ArrayList 의 순서와 사다리 층수 순서를 맞춘다.
        Collections.reverse(result);
        return new LadderJointsContainer(result);
    }

    // 사다리 라인의 마지막 joint 객체에 down 시 당첨 탈락 여부를 표시한다.
    public void makeDownGoal(Boolean check) {
        ladderJointsContainer.get(height - 1).makeDownGoal(check);
    }

    public Integer getHeight() {
        return height;
    }

    public LadderJointsContainer getLadderJointsContainer() {
        return ladderJointsContainer;
    }

    public String getResult() {
        return result;
    }

    public LadderJoint getResultIfStartThisLine() {
        LadderJoint prevJoint = null;
        LadderJoint presentJoint = ladderJointsContainer.get(0);
        LadderJoint swapJointVariable;
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        return presentJoint;
    }
}