package step2.view.input;

import step2.dto.LadderConfig;
import step2.exception.CustomNumberFormatException;
import step2.exception.InputCountExceededException;
import step2.util.TypeConverter;

import java.util.Scanner;

public class HeightAndPeopleInputInterface implements InputInterface {

    //TODO 입력 부분 변경이 조금 필요할듯?

    private final int threshold = 3;

    @Override
    public LadderConfig inputLadderConfig() {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfPeople = inputNumOfPeople(sc);
            int height = inputHeight(sc);

            return LadderConfig.of(numOfPeople, height);
        }
    }

    private int inputNumOfPeople(Scanner sc) {
        final String numOfPeopleStr = "참여할 사람은 몇 명인가요? ";

        return inputPositiveNumber(numOfPeopleStr, sc, 0);
    }

    private int inputHeight(Scanner sc) {
        final String heightStr = "최대 사다리 높이는 몇 개인가요? ";

        return inputPositiveNumber(heightStr, sc, 0);
    }

    private int inputPositiveNumber(String msg, Scanner sc, int count) {
        System.out.println(msg + count + "/" + threshold);

        try {
            checkThresholdAndThrowException(count);

            String result = sc.next();
            return TypeConverter.strToInteger(result);

        } catch (CustomNumberFormatException e) {
            System.out.println(e.getMessage());
            return inputPositiveNumber(msg, sc, count + 1);

        } catch (InputCountExceededException e) {
            System.out.println(e.getMessage());
            sc.close();
            System.exit(0);
        }

        throw new RuntimeException();
    }

    private void checkThresholdAndThrowException(int count) {
        if (count >= threshold) {
            throw new InputCountExceededException();
        }
    }
}
