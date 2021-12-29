package game.ladder;

import java.util.ArrayList;
import java.util.Collections;

public class LadderLine {
    private final Integer height;
    private final ArrayList<LadderJoint> ladderJointArrayList;

    public LadderLine(Integer height) {
        this.height = height;
        this.ladderJointArrayList = new ArrayList<>(height);
        makeJointsAndDownConnect();
    }

    // Line 에 포함된 Joint 들을 만들고 아래로 내려가는 참조 필드를 연결시킨다.
    private void makeJointsAndDownConnect() {
        LadderJoint presentJoint;
        LadderJoint downerJoint = null;
        for (int i = this.height - 1; i >= 0; i--) {
            presentJoint = new LadderJoint();
            presentJoint.connectDownJoint(downerJoint);
            ladderJointArrayList.add(presentJoint);
            downerJoint = presentJoint;
        }
        // ArrayList 의 순서와 사다리 층수 순서를 맞춘다.
        Collections.reverse(ladderJointArrayList);
    }

    // 사다리 라인의 마지막 joint 객체에 down 시 당첨 탈락 여부를 표시한다.
    public void makeDownGoal(Boolean check) {
        ladderJointArrayList.get(height - 1).makeDownGoal(check);
    }

    public Integer getHeight() {
        return height;
    }

    public ArrayList<LadderJoint> getLadderJointArrayList() {
        return ladderJointArrayList;
    }


}