package laddergame.view.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputStringList implements Input<List<String>> {
    private final String DELIMITER = ",";
    private final int MAX_LENGTH = 5;

    private Scanner scanner = new Scanner(System.in);
    private List<String> inputValues = new ArrayList<String>();

    public InputStringList() {
    }

    public List<String> getInputValue() {
        Boolean isDone = false;
        while (!isDone) {
            getNewInput();
            isDone = (inputValues.size() != 0);
        }

        return inputValues;
    }

    private void getNewInput() {
        try {
            String input = scanner.nextLine();
            List<String> inputValues = makeArrayList(input);

            checkInputMaxLength(inputValues);

            this.inputValues = inputValues;
        } catch (InputValidException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> makeArrayList(String inputValue) {
        return Arrays.asList(inputValue.split(DELIMITER));
    }

    private void checkInputMaxLength(List<String> inputValues) throws InputValidException {
        for (var name : inputValues) {
            checkInputMaxLength(name);
        }
    }

    private void checkInputMaxLength(String name) throws InputValidException {
        if (name.length() > MAX_LENGTH) {
            String MAX_LENGTH_EXCEED_MESSAGE = String.format("입력한 참여한 사람 이름 %s 의 글자 수가 %d 보다 많습니다. 다시 입력해주세요.", name, MAX_LENGTH);
            throw new InputValidException(MAX_LENGTH_EXCEED_MESSAGE);
        }
    }
}