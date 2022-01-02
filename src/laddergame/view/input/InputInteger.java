package laddergame.view.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputInteger implements Input<Integer> {
    private Scanner scanner = new Scanner(System.in);
    private Integer inputValue = 0;

    public InputInteger() {
    }

    public Integer getInputValue() {
        Boolean isDone = false;
        while(!isDone) {
            getNewInput();
            isDone = (inputValue != 0);
        }

        return inputValue;
    }

    private void getNewInput() {
        try {
            int inputValue = scanner.nextInt();
            checkInputValueRange(inputValue);

            this.inputValue = inputValue;
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 정수만 입력 가능합니다.");
            scanner.next();
        } catch (InputValidException e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkInputValueRange(int inputValue) throws InputValidException {
        String UNVALID_RANGE_MESSAGE = "잘못된 입력입니다. 1 이상의 정수만 입력 가능합니다.";
        if(inputValue <= 0)
            throw new InputValidException(UNVALID_RANGE_MESSAGE);
    }
}