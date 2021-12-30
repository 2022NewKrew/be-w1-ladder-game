package rubam.step4.input;

import rubam.step4.domain.Ladder;
import rubam.step4.domain.LadderFactory;

import java.util.*;

public class InputLadderInform {

    private static final String NAME_INPUT_MESSAGE = "참여할 사람 이름을 입력하세요";
    private static final String HEIGHT_INPUT_MESSAGE = "최대 사다리 높이는 몇인가요?";
    private static final String INPUT_MISMATCH_EXCEPTION_ERROR_MESSAGE = "숫자로 입력해주세요.";
    private static final String SPLIT_POINT = ",";

    private static final LadderInformDTO dto = new LadderInformDTO();
    private static final Scanner scanner = new Scanner(System.in);

    private InputLadderInform() {

    }

    public static Ladder userInput() {
        Ladder ladder = null;
        while (ladder == null) {
            inputNames();
            inputHeight();
            ladder = checkLadderData();
        }
        return ladder;
    }

    private static Ladder checkLadderData() {
        try {
            return LadderFactory.createLadder(dto.getNames(), dto.getHeight());
        } catch (LadderInputException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private static void inputHeight() {
        boolean isDone = false;
        while (!isDone) {
            isDone = checkHeightType();
        }
    }

    private static Boolean checkHeightType() {
        try {
            System.out.println(HEIGHT_INPUT_MESSAGE);
            dto.setHeight(scanner.nextInt());
            scanner.nextLine();
            return true;
        } catch (InputMismatchException e) {
            System.out.println(INPUT_MISMATCH_EXCEPTION_ERROR_MESSAGE);
            scanner.nextLine();
        }
        return false;
    }

    private static void inputNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        String inputData = scanner.nextLine();

        dto.setNames(Arrays.asList(inputData.split(SPLIT_POINT)));
    }
}
