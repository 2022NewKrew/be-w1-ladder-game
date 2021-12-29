package ladderGame.util.consoleInput;

import ladderGame.exception.CustomFormatException;
import ladderGame.exception.ladderException.ConsoleInputCountExceededException;
import ladderGame.util.ResourceManager;

import java.util.Scanner;

public abstract class InputConsole<T> {

    private final int THRESHOLD = 3;

    private final Scanner sc = ResourceManager.SCANNER;

    public T read(String msg) throws ConsoleInputCountExceededException {
        return read(msg, 0);
    }

    private T read(String msg, int count) throws ConsoleInputCountExceededException {
        System.out.printf("%s %d/%d%n", msg, count, THRESHOLD);

        try {
            checkThresholdAndThrowException(count);

            String inputStr = sc.nextLine();
            return convert(inputStr);
        } catch (CustomFormatException e) {
            System.out.println(e.getMessage());
            return read(msg, count + 1);
        }
    }

    abstract public T convert(String inputStr);

    private void checkThresholdAndThrowException(int count) {
        if (count >= THRESHOLD) {
            throw new ConsoleInputCountExceededException();
        }
    }
}
