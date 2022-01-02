package laddergame.view.input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputStringList implements Input<List<String>> {
    private final String DELIMITER = ",";
    private final int TARGET_COUNT = 5;

    private Scanner scanner = new Scanner(System.in);
    private List<String> inputValues = new ArrayList<String>();

    public InputStringList() {
    }

    public List<String> getInputValue() {
        Boolean isDone = false;
        while(!isDone) {
            getNewInput();
            isDone = (inputValues.size() == 5);
        }

        return inputValues;
    }

    private void getNewInput() {
        try {
            String input = scanner.nextLine();
            List<String> inputValues = makeArrayList(input);

            int count = inputValues.size();
            checkInputCountLack(count);
            checkInputCountExceed(count);

            this.inputValues = inputValues;
        } catch (InputValidException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<String> makeArrayList(String inputValue) {
        return Arrays.asList(inputValue.split(DELIMITER));
    }

    private void checkInputCountLack(int count) throws InputValidException {
        if(count < TARGET_COUNT)
            throw new InputValidException("입력된 사람 수가 " + TARGET_COUNT + "명 보다 많습니다. 다시 입력해주세요.");
    }

    private void checkInputCountExceed(int count) throws InputValidException {
        if(count > TARGET_COUNT)
            throw new InputValidException("입력한 사람 수가 " + TARGET_COUNT + "명 보다 적습니다. 다시 입력해주세요.");
    }
}