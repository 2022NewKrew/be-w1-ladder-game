package rubam.step4.domain;

import rubam.step4.input.LadderInputException;
import java.util.List;

public class LadderFactory {

    private static final int MAX_LENGTH = 5;
    private static final String PREFIX_NAME_SIZE_ERROR_MESSAGE = "이름을 ";
    private static final String LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE = "이내의 크기로 입력해주세요.";
    private static final String LADDER_INPUT_HEIGHT_ERROR_MESSAGE = "최소 1 이상의 높이로 지정해주세요.";

    private LadderFactory() {

    }

    public static Ladder createLadder(List<String> names, int height) {
        checkNames(names);
        checkHeight(height);
        int num = names.size();

        return new Ladder(num, height, names);
    }

    private static void checkNames(List<String> names) {
        for (String i : names) {
            checkNameSize(i);
        }
    }

    private static void checkNameSize(String i) throws LadderInputException {
        if (i.length() > MAX_LENGTH) {
            throw new LadderInputException(PREFIX_NAME_SIZE_ERROR_MESSAGE + MAX_LENGTH + LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkHeight(int height) throws LadderInputException {
        if (height < 1) {
            throw new LadderInputException(LADDER_INPUT_HEIGHT_ERROR_MESSAGE);
        }
    }
}
