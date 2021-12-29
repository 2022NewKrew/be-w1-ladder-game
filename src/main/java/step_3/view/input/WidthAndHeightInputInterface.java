package step_3.view.input;

import step_3.dto.WidthAndHeightInfo;

import java.util.Scanner;

import static step_2.Validator.checkPositiveInteger;

public class WidthAndHeightInputInterface implements InputInterface {
    @Override
    public WidthAndHeightInfo inputArguments() {
        int width;
        int height;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("참여할 사람은 몇 명인가요?");
            width = scanner.nextInt();
            checkPositiveInteger(width, "사람의 수는 0명보다 커야합니다.");

            System.out.println("최대 사다리 높이는 몇 개 인가요?");
            height = scanner.nextInt();
            checkPositiveInteger(height, "사다리의 높이는 0보다 커야합니다.");
        }

        return new WidthAndHeightInfo(width, height);
    }
}
