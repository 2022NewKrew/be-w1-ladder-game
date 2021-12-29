import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler {
    private static final int MAX_NAME_LENGTH = 5;

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

    public List<String> getPeople() {
        List<String> peopleList;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String peopleString = scanner.nextLine();
        peopleList = List.of(peopleString.split(","));
        peopleList.forEach(this::validateName);

        return peopleList;
    }

    private void validatePositiveInteger(int value) throws InputMismatchException {
        if (value <= 0) {
            throw new InputMismatchException();
        }
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            System.err.println("이름은 5글자 까지만 입력 가능합니다.");
            System.exit(1);
        }
    }
}
