package game.ladder;

public class LadderJoint {
    // 인접 LadderJoint 에 대한 참조 멤버변수
    private LadderJoint leftOrRightJoint = null;
    private LadderJoint down = null;
    private Boolean isDownGoal = false;

    public LadderJoint() {
    }

    // Joint 의 아래 Joint 를 연결하는 메소드
    public void connectDownJoint(LadderJoint down) {
        this.down = down;
    }

    // Joint 의 좌우 Joint 를 연결하는 메소드
    public void connectSideJoint(LadderJoint leftOrRightJoint) {
        this.leftOrRightJoint = leftOrRightJoint;
    }

    // 골인지점
    public void makeDownGoal(Boolean check) {
        isDownGoal = check;
    }

    // 사다리 흐름상 다음 LadderJoint 를 반환하는 메소드
    public LadderJoint next(LadderJoint prevJoint) {
        // 옆에서 온 흐름이면 아래로 내려보낸다.
        // 맨 처음이면 prevJoint 가 null 이며 위에서 온 흐름이다.
        if (prevJoint != null && prevJoint.equals(leftOrRightJoint)) {
            return down;
        }
        // 위에서 온 흐름인데 옆으로 갈 수 있으면 옆으로 보낸다.
        if (leftOrRightJoint != null) {
            return leftOrRightJoint;
        }
        // 위에서 온 흐름인데 옆으로 갈 수 없으면 아래로 보낸다.
        return down;
    }

    public Boolean getDownGoal() {
        return isDownGoal;
    }

    public LadderJoint getLeftOrRightJoint() {
        return leftOrRightJoint;
    }
}
