package laddergame.view.input;

import java.io.InputStream;
import java.util.Scanner;

public interface Input<InputType> {
    public static InputStream inputStream = System.in;
    public static Scanner scanner = new Scanner(inputStream);

    public InputType getInputValue();
}
