package rubam.step5.domain;

import rubam.step5.input.LadderInputException;

import java.util.List;

public class LadderFactory {

    private static final int MAX_LENGTH = 5;
    private static final String PREFIX_NAME_SIZE_ERROR_MESSAGE = "이름을 ";
    private static final String LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE = "이내의 크기로 입력해주세요.";
    private static final String LADDER_INPUT_HEIGHT_ERROR_MESSAGE = "최소 1 이상의 높이로 지정해주세요.";
    private static final String LADDER_INPUT_RESULT_ERROR_MESSAGE = "결과의 개수가 올바르지 않습니다.";

    private LadderFactory() {

    }

    public static Ladder createLadder(List<String> names, int height, List<String> results) {
        checkNames(names);
        checkHeight(height);
        int num = names.size();
        checkResultCount(results, num);

        return new Ladder(num, height, names, results);
    }

    private static void checkNames(List<String> names) {
        for (String i : names) {
            checkNameSize(i);
        }
    }

    private static void checkNameSize(String name) throws LadderInputException {
        if (name.length() > MAX_LENGTH) {
            throw new LadderInputException(PREFIX_NAME_SIZE_ERROR_MESSAGE + MAX_LENGTH + LADDER_INPUT_NAME_SIZE_ERROR_MESSAGE);
        }
    }

    private static void checkHeight(int height) throws LadderInputException {
        if (height < 1) {
            throw new LadderInputException(LADDER_INPUT_HEIGHT_ERROR_MESSAGE);
        }
    }

    private static void checkResultCount(List<String> results, int peopleNum) {
        if (results.size() != peopleNum) {
            throw new LadderInputException(LADDER_INPUT_RESULT_ERROR_MESSAGE);
        }
    }
}
