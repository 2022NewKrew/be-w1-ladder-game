package laddergame.view.input;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputStringList implements Input<List<String>> {
    private static Scanner scanner = new Scanner(System.in);

    private final String DELIMITER = ",";

    public InputStringList() {
    }

    public List<String> getInputValue() {
        String inputValue = scanner.nextLine();
        return makeArrayList(inputValue);
    }

    private List<String> makeArrayList(String inputValue) {
        return Arrays.asList(inputValue.split(DELIMITER));
    }
}