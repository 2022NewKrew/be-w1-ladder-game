package application;

import domain.User;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static application.LadderGame.MAXIMUM_NAME_LENGTH;

public class GameInputScanner {
    private static final Scanner in = new Scanner(System.in);

    public static List<User> inputNameList() {
        try {
            List<String> nameList = inputStringSeparator(in.nextLine());
            verifyInputNameList(nameList);
            return IntStream.range(0, nameList.size())
                    .mapToObj(i -> new User(nameList.get(i), i))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputNameList();
        }
    }

    public static List<String> inputResultList(int numberOfPeople) {
        try {
            List<String> resultList = inputStringSeparator(in.nextLine());
            verifyInputResultList(numberOfPeople, resultList);
            return resultList;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return inputResultList(numberOfPeople);
        }
    }

    private static List<String> inputStringSeparator(String input) {
        return Collections.list(new StringTokenizer(input, ","))
                .stream()
                .map(token -> ((String) token).trim())
                .collect(Collectors.toList());
    }

    private static void verifyInputNameList(List<String> nameList) throws RuntimeException {
        boolean existWrongName = nameList.stream()
                .anyMatch(e -> (e.length() == 0) || (e.length() > MAXIMUM_NAME_LENGTH));
        if (existWrongName) {
            throw new RuntimeException("참여할 사람 이름을 정확하게 입력해주세요.");
        }
    }

    private static void verifyInputResultList(int numberOfPeople, List<String> resultList) {
        if (resultList.isEmpty() || resultList.size() != numberOfPeople)
            throw new RuntimeException("실행 결과를 정확하게 입력해주세요.");
    }

    public static int inputNumber() {
        try {
            return getPositiveInteger();
        } catch (NumberFormatException e) {
            System.out.println("양의 정수를 입력해주세요.");
            return inputNumber();
        }
    }

    private static int getPositiveInteger() {
        int value = Integer.parseInt(in.nextLine());
        if (value <= 0) {
            throw new NumberFormatException();
        }
        return value;
    }
}
