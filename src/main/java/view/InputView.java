package view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;

    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int getHeight() {
        int height = 0;

        System.out.println("최대 사다리 높이는 몇 개 인가요?");
        try{
            height = Integer.parseInt(scanner.nextLine());
            validatePositiveInteger(height);
        } catch (NumberFormatException | NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return height;
    }

    public List<String> getPeople() {
        List<String> peopleList = null;

        System.out.println("참여할 사람 이름을 입력하세요. (이름은 " + MAX_NAME_LENGTH + "글자까지 입력 가능하며, 쉼표(,)로 구분하세요)");
        try {
            String peopleString = scanner.nextLine();
            peopleList = List.of(peopleString.split(","));
            peopleList.forEach(this::validateName);
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return peopleList;
    }

    public List<String> getResults() {
        List<String> resultList = null;

        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        try {
            String resultString = scanner.nextLine();
            resultList = List.of(resultString.split(","));
        } catch (NoSuchElementException | IllegalStateException exception) {
            System.err.println("입력을 처리할 수 없습니다.");
            System.exit(1);
        }

        return resultList;
    }

    private void validatePositiveInteger(int value) throws InputMismatchException {
        if (value <= 0) {
            throw new InputMismatchException();
        }
    }

    private void validateName(String name) throws InputMismatchException{
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new InputMismatchException();
        }
    }
}
