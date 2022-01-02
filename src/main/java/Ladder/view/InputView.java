package Ladder.view;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    //이름이 입력되지 않은 경우 예외처리
    //이름이 정해진 길이를 넘어서는 경우는 출력시에 처리하는것으로 설정.
    public static @NotNull List<String> inputPeopleName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String people = sc.next();
        List<String> retList = new ArrayList<>(Arrays.asList(people.split(",")));

        if (retList.size() == 0 || retList.contains("") ||
                (people.charAt(people.length() - 1) == ',')) {
            System.out.println("이름은 1자 이상 써주세요. 이름에는 쉠표가 포함 될 수 없습니다");
            return inputPeopleName();
        }
        return retList;
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = sc.nextInt();

        if (height <= 0) {
            System.out.println("사다리의 높이는 자연수이여야 합니다");
            return inputHeight();
        }

        return height;
    }
}
