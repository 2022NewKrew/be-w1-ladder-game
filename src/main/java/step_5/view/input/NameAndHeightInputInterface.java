package step_5.view.input;

import step_5.dto.NameAndHeightInfo;

import java.util.Scanner;

import static step_3.domain.Validator.checkNameLength;
import static step_3.domain.Validator.checkPositiveInteger;

public class NameAndHeightInputInterface implements InputInterface {
    public static final int maxNameLength = 5;
    private final String delimiter = ",";

    @Override
    public NameAndHeightInfo inputArguments() {
        String[] names;
        int height;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            names = scanner.nextLine().split(delimiter);
            checkNameLength(names, maxNameLength, "사람 이름의 길이는 " + Integer.toString(maxNameLength) + "보다 작거나 같아야합니다.");

            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            height = scanner.nextInt();
            checkPositiveInteger(height, "사다리의 높이는 0보다 커야합니다.");
        }

        return new NameAndHeightInfo(names, height);
    }
}
