package laddergame.view.input;

import java.util.Scanner;

public class InputInteger implements Input<Integer> {
    private static Scanner scanner = new Scanner(System.in);

    public InputInteger() {
    }

    public Integer getInputValue() {
        return scanner.nextInt();
    }
}