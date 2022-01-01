package laddergame.view.input;

import java.util.ArrayList;
import java.util.Arrays;

public class InputArrayListString implements Input<ArrayList<String>> {
    private final String DELIMITER = ",";

    public InputArrayListString() {
    }

    public ArrayList<String> getInputValue() {
        String inputValue = scanner.nextLine();
        return makeArrayList(inputValue);
    }

    private ArrayList<String> makeArrayList(String inputValue) {
        return Arrays.asList(inputValue.split(DELIMITER));
    }
}