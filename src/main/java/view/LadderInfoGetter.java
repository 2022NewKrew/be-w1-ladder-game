package view;

import DTO.InputDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LadderInfoGetter {
    private static final Scanner scanner = new Scanner(System.in);

    public static InputDTO getInfoFromClient() {
        List<String> people = inputPeople();
        List<String> results = inputResults();
        int heightOfLadder = inputHeightOfLadder();
        return new InputDTO(people, results, heightOfLadder);
    }

    private static List<String> inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    private static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return Arrays.asList(scanner.nextLine().split(","));
    }

    private static int inputHeightOfLadder() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}
