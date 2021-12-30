package ladder.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);
    private static final String SPLIT_REGEX = ",";

    private Input() {}

    public static ArrayList<String> getPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        ArrayList<String> userInput = new ArrayList<>(Arrays.asList(sc.nextLine().split(SPLIT_REGEX)));
        boolean isValidated = userInput.stream().allMatch(str -> str.length() < 6 && str.length() > 0);
        if (isValidated) return userInput;
        System.out.println("이름을 형식에 맞게 다시 입력하세요. (이름은 1~5자 사이로 입력하세요)");
        return getPlayerNames();
    }

    public static int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String userInput = sc.nextLine();
        boolean isValidated = userInput.chars().allMatch( Character::isDigit );
        if (isValidated) return Integer.parseInt(userInput);
        System.out.println("최대 사디로 높이는 숫자로만 입력하세요");
        return getLadderHeight();
    }
}