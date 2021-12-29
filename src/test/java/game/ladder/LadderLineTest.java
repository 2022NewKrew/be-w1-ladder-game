package game.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    public void makeLineAndCheckHeight() {
        LadderLine line = new LadderLine(5);

        Assertions.assertThat(line.getHeight()).isEqualTo(5);
        Assertions.assertThat(line.getLadderJointArrayList().size()).isEqualTo(5);
    }

    @Test
    public void makeLineAndCheckJointChain() {
        LadderLine line = new LadderLine(3);
        LadderJoint joint0 = line.getLadderJointArrayList().get(0);
        LadderJoint joint1 = line.getLadderJointArrayList().get(1);
        LadderJoint joint2 = line.getLadderJointArrayList().get(2);

        Assertions.assertThat(joint0.next(null)).isEqualTo(joint1);
        Assertions.assertThat(joint1.next(joint0)).isEqualTo(joint2);
        Assertions.assertThat(joint2.next(joint1)).isEqualTo(null);
    }

    @Test
    public void findGoalOkTest() {
        LadderLine line = new LadderLine(3);
        LadderJoint joint0 = line.getLadderJointArrayList().get(0);
        LadderJoint joint1 = line.getLadderJointArrayList().get(1);
        LadderJoint joint2 = line.getLadderJointArrayList().get(2);
        joint2.makeDownGoal(true);

        LadderJoint prevJoint = null;
        LadderJoint presentJoint = joint0;
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
    public void findGoalNotOkTest() {
        LadderLine line = new LadderLine(3);
        LadderJoint joint0 = line.getLadderJointArrayList().get(0);
        LadderJoint joint1 = line.getLadderJointArrayList().get(1);
        LadderJoint joint2 = line.getLadderJointArrayList().get(2);
        joint2.makeDownGoal(false);

        LadderJoint prevJoint = null;
        LadderJoint presentJoint = joint0;
        LadderJoint swapJointVariable;
        // 다음에 갈곳이 null일 때까지 순회
        while(presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(false);
    }

}