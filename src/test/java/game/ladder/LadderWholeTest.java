package game.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LadderWholeTest {
    @Test
    public void checkShuffledLineGoalTest1() {
        LadderLine leftLine = new LadderLine(3);
        LadderLine rightLine = new LadderLine(3);

        LadderJoint leftjoint0 = leftLine.getLadderJointArrayList().get(0);
        LadderJoint leftjoint1 = leftLine.getLadderJointArrayList().get(1);
        LadderJoint leftjoint2 = leftLine.getLadderJointArrayList().get(2);
        leftjoint2.makeDownGoal(true);

        LadderJoint rightjoint0 = rightLine.getLadderJointArrayList().get(0);
        LadderJoint rightjoint1 = rightLine.getLadderJointArrayList().get(1);
        LadderJoint rightjoint2 = rightLine.getLadderJointArrayList().get(2);
        rightjoint2.makeDownGoal(false);

        leftjoint0.connectSideJoint(rightjoint0);
        rightjoint0.connectSideJoint(leftjoint0);
        leftjoint2.connectSideJoint(rightjoint2);
        rightjoint2.connectSideJoint(leftjoint2);

        LadderJoint prevJoint = null;
        LadderJoint presentJoint = leftjoint0;
        LadderJoint swapJointVariable;
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(true);
    }

    @Test
    public void checkShuffledLineGoalTest2() {
        LadderWhole ladder = new LadderWhole(3,3, new ArrayList<String>(List.of("one", "two", "three")));

        ArrayList<LadderLine> lines = ladder.getLadderLineArrayList();

        ArrayList<LadderJoint> joints1 = lines.get(0).getLadderJointArrayList();
        ArrayList<LadderJoint> joints2 = lines.get(1).getLadderJointArrayList();
        ArrayList<LadderJoint> joints3 = lines.get(2).getLadderJointArrayList();

        lines.get(0).makeDownGoal(true);

        joints1.get(1).connectSideJoint(joints2.get(1));
        joints2.get(1).connectSideJoint(joints1.get(1));
        joints2.get(0).connectSideJoint(joints3.get(0));
        joints3.get(0).connectSideJoint(joints2.get(0));
        joints2.get(2).connectSideJoint(joints3.get(2));
        joints3.get(2).connectSideJoint(joints2.get(2));

        LadderJoint prevJoint, presentJoint, swapJointVariable;

        prevJoint = null;
        presentJoint = joints1.get(0);
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(false);

        prevJoint = null;
        presentJoint = joints2.get(0);
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(false);

        prevJoint = null;
        presentJoint = joints3.get(0);
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(true);


    }



}