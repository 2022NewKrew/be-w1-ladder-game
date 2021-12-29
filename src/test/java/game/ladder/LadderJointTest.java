package game.ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderJointTest {

    @Test
    public void ladderJointUpToDownConnection() {
        // given
        LadderJoint upJoint = new LadderJoint();
        LadderJoint midJoint = new LadderJoint();
        LadderJoint rightJoint = new LadderJoint();
        LadderJoint leftJoint = new LadderJoint();
        LadderJoint downJoint = new LadderJoint();
        // when
        midJoint.connectDownJoint(downJoint);
        // then
        Assertions.assertThat(midJoint.next(upJoint)).isEqualTo(downJoint);
    }

    @Test
    public void ladderJointLeftToDownConnection() {
        // given
        LadderJoint upJoint = new LadderJoint();
        LadderJoint midJoint = new LadderJoint();
        LadderJoint rightJoint = new LadderJoint();
        LadderJoint leftJoint = new LadderJoint();
        LadderJoint downJoint = new LadderJoint();
        // when
        midJoint.connectDownJoint(downJoint);
        midJoint.connectSideJoint(leftJoint);
        // then
        Assertions.assertThat(midJoint.next(leftJoint)).isEqualTo(downJoint);
        Assertions.assertThat(midJoint.next(upJoint)).isEqualTo(leftJoint);
    }

    @Test
    public void ladderJointLeftToDownNullConnection() {
        // given
        LadderJoint upJoint = new LadderJoint();
        LadderJoint midJoint = new LadderJoint();
        LadderJoint rightJoint = new LadderJoint();
        LadderJoint leftJoint = new LadderJoint();
        LadderJoint downJoint = new LadderJoint();
        // when
        midJoint.connectDownJoint(null);
        midJoint.connectSideJoint(leftJoint);
        // then
        Assertions.assertThat(midJoint.next(leftJoint)).isEqualTo(null);
        Assertions.assertThat(midJoint.next(upJoint)).isEqualTo(leftJoint);
    }

    @Test
    public void checkGoalTrue() {
        // given
        LadderJoint joint = new LadderJoint();
        // when
        joint.makeDownGoal(true);
        // then
        Assertions.assertThat(joint.getDownGoal()).isEqualTo(true);
    }

    @Test
    public void checkGoalFalse() {
        // given
        LadderJoint joint = new LadderJoint();
        // when

        // then
        Assertions.assertThat(joint.getDownGoal()).isEqualTo(false);

    }

}