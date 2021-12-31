package step_5.view.input;

import step_5.dto.LadderInfo;
import step_5.dto.NameAndResultInfo;

import java.util.Arrays;
import java.util.Scanner;

import static step_5.domain.Validator.*;

public class NameAndResultInputInterface implements InputInterface {
    public static final int maxNameLength = 5;
    private static final String delimiter = ",";
    public static final String finisher = "춘식이";

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public NameAndResultInfo inputArguments() {
        String[] names;
        String[] results;
        int height;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        names = scanner.nextLine().split(delimiter);
        System.out.println(Arrays.toString(names));
        checkNameLength(names, maxNameLength, "사람 이름의 길이는 " + Integer.toString(maxNameLength) + "보다 작거나 같아야 합니다.");
        System.out.println();

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        results = scanner.nextLine().split(delimiter);
        System.out.println(Arrays.toString(results));
        checkNotMatched(names, results, "사람의 인원 수와 실행 결과의 수가 동일해야 합니다.");
        System.out.println();

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        height = Integer.parseInt(scanner.nextLine());
        checkPositiveInteger(height, "사다리의 높이는 0보다 커야 합니다.");
        System.out.println();

        return new NameAndResultInfo(names, results, height);
    }

    public static String inputNameforResult(LadderInfo ladderInfo) {
        String name;

        System.out.println("결과를 보고 싶은 사람은?");
        name = scanner.next();
        checkNameInNames(ladderInfo, name, finisher, "올바른 이름을 입력하세요.");
        System.out.println();

        return name;
    }
}
