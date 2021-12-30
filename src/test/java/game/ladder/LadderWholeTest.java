package game.ladder;

import game.ladder.Utils.LadderJointsContainer;
import game.ladder.Utils.LadderLinesContainer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LadderWholeTest {

    LadderWhole ladder = new LadderWhole(3, 5, new ArrayList<String>(List.of("a", "bb", "ccc", "dddd", "eeeee")), new ArrayList<String>(List.of("1", "0", "0", "0", "0")));

    LadderLinesContainer lines = ladder.getLadderLinesContainer();

    LadderJointsContainer joints1 = lines.get(0).getLadderJointsContainer();
    LadderJointsContainer joints2 = lines.get(1).getLadderJointsContainer();
    LadderJointsContainer joints3 = lines.get(2).getLadderJointsContainer();

    @Test
    @DisplayName("사다리 결과를 출력할 때 최대 5 글자를 정확히 출력하는지 테스트")
    public void check5NameCharacterOutput() {
        String result = ladder.printLadder();
        Assertions.assertThat(result).contains("a");
        Assertions.assertThat(result).contains("bb");
        Assertions.assertThat(result).contains("ccc");
        Assertions.assertThat(result).contains("dddd");
        Assertions.assertThat(result).contains("eeeee");
    }


    @Test
    public void checkShuffledLineGoalTest1() {
        LadderLine leftLine = new LadderLine(3, "");
        LadderLine rightLine = new LadderLine(3, "");

        LadderJoint leftjoint0 = leftLine.getLadderJointsContainer().get(0);
        LadderJoint leftjoint1 = leftLine.getLadderJointsContainer().get(1);
        LadderJoint leftjoint2 = leftLine.getLadderJointsContainer().get(2);
        leftjoint2.makeDownGoal(true);

        LadderJoint rightjoint0 = rightLine.getLadderJointsContainer().get(0);
        LadderJoint rightjoint1 = rightLine.getLadderJointsContainer().get(1);
        LadderJoint rightjoint2 = rightLine.getLadderJointsContainer().get(2);
        rightjoint2.makeDownGoal(false);

        leftjoint0.connectSideJoint(rightjoint0);
        rightjoint0.connectSideJoint(leftjoint0);
        leftjoint2.connectSideJoint(rightjoint2);
        rightjoint2.connectSideJoint(leftjoint2);

        LadderJoint prevJoint = null;
        LadderJoint presentJoint = leftjoint0;
        LadderJoint swapJointVariable;
        // 다음에 갈곳이 null일 때까지 순회
        while (presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(true);
    }

    @Test
    public void checkShuffledLineGoalTest2() {

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
        while (presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(false);

        prevJoint = null;
        presentJoint = joints2.get(0);
        // 다음에 갈곳이 null일 때까지 순회
        while (presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(false);

        prevJoint = null;
        presentJoint = joints3.get(0);
        // 다음에 갈곳이 null일 때까지 순회
        while (presentJoint.next(prevJoint) != null) {
            swapJointVariable = presentJoint;
            presentJoint = presentJoint.next(prevJoint);
            prevJoint = swapJointVariable;
        }
        Assertions.assertThat(presentJoint.getDownGoal()).isEqualTo(true);


    }


}