package application;

import domain.Ladder;
import view.LadderPrinter;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class LadderGame {
    private static final Scanner in = new Scanner(System.in);
    public static final int MAXIMUM_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> nameList = inputNameList();

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightLadder = inputNumber();

        Ladder ladder = new Ladder(LadderFactory.getLadderRows(nameList.size() - 1, heightLadder));
        LadderPrinter.drawLadder(nameList, ladder);
    }

    private static List<String> inputNameList() {
        return convertStringToNameList(in.nextLine());
    }

    private static List<String> convertStringToNameList(String input) {
        return Collections.list(new StringTokenizer(input, ","))
                .stream()
                .map(token -> ((String) token).trim())
                .filter(e -> (e.length() > 0) && (e.length() <= MAXIMUM_NAME_LENGTH))
                .collect(Collectors.toList());
    }

    private static int inputNumber() {
        try {
            return getPositiveInteger();
        } catch (NumberFormatException e) {
            System.out.println("양의 정수를 입력해주세요.");
            return inputNumber();
        }
    }

    private static Integer getPositiveInteger() {
        Integer value = Integer.valueOf(in.nextLine());
        if (value <= 0) {
            throw new NumberFormatException();
        }
        return value;
    }
}