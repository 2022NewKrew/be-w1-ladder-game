package view.scanner;

import exception.IllegalInputException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringScanner {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> getStringList(String message, int maxNameLength) {
        while(true) {
            System.out.println(message);
            try {
                return getValidStringList(sc.nextLine(), maxNameLength);
            } catch (IllegalInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<String> getValidStringList(String nameList, int maxNameLength) {
        List<String> nameInput = Arrays.asList(nameList.split(","));
        if (nameInput.stream().anyMatch(name -> name.length() > maxNameLength))
            throw new IllegalInputException("최대 글자수를 넘은 이름이 있습니다.");
        return nameInput;
    }

    public static String getString(String message) {
        System.out.println(message);
        return sc.nextLine();
    }
}
