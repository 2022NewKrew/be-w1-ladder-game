package preconditions;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PreconditionTest {
    private static final int TEST_MAX_LENGTH = 5;
    public static final int TEST_ILLEGAL_FRAME_LENGTH = 0;
    public static final int TEST_MIN_LENGTH = 1;
    public static final int TEST_LEGAL_FRAME_LENGTH = 5;
    public static final int TEST_LEGAL_LADDER_HEIGHT = 5;
    public static final int TEST_ILLEGAL_LADDER_HEIGHT = 0;

    @Test
    void checkUsers() {
        List<String> testLegalUsers = new ArrayList<>();
        testLegalUsers.add("zxc");
        testLegalUsers.add("qxc");
        testLegalUsers.add("axcsd");
        testLegalUsers.add("dxc");
        testLegalUsers.add("sxc");

        List<String> testIllegalUsers = new ArrayList<>();
        testIllegalUsers.add("zxc");
        testIllegalUsers.add("zxcvb");
        testIllegalUsers.add("asdfgq");
        testIllegalUsers.add("zxc");
        testIllegalUsers.add("zxc");

        assertThatCode(() -> Precondition.checkUsers(testLegalUsers, TEST_MAX_LENGTH)).doesNotThrowAnyException();
        assertThatThrownBy(() -> Precondition.checkUsers(testIllegalUsers, TEST_MAX_LENGTH)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNumberOfPerson() {
        assertThatCode(() -> Precondition.checkFrameLength(TEST_LEGAL_FRAME_LENGTH, TEST_MIN_LENGTH)).doesNotThrowAnyException();
        assertThatThrownBy(() -> Precondition.checkFrameLength(TEST_ILLEGAL_FRAME_LENGTH, TEST_MIN_LENGTH))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkLadderHeight() {
        assertThatCode(() -> Precondition.checkLadderHeight(TEST_LEGAL_LADDER_HEIGHT, TEST_MIN_LENGTH)).doesNotThrowAnyException();
        assertThatThrownBy(() -> Precondition.checkLadderHeight(TEST_ILLEGAL_LADDER_HEIGHT, TEST_MIN_LENGTH))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
