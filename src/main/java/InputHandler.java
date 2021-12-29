import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    public int getPeopleSize() {
        int peopleSize = 0;

        System.out.println("참여할 사람은 몇 명 인가요?");
        try{
            peopleSize = scanner.nextInt();
            validatePositiveInteger(peopleSize);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return peopleSize;
    }

    public int getHeight() {
        int height = 0;

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        try{
            height = scanner.nextInt();
            validatePositiveInteger(height);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return height;
    }

    private void validatePositiveInteger(int value) throws InputMismatchException {
        if (value <= 0) {
            throw new InputMismatchException();
        }
    }
}
