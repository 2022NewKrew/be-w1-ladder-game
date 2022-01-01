package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Result;
import ladder.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Engine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public List<User> inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputList = scanner.nextLine().split(DELIMITER);

        return Arrays.stream(inputList)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Result> inputResult() {
        System.out.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)\n", DELIMITER);
        String[] inputList = scanner.nextLine().split(DELIMITER);

        return Arrays.stream(inputList)
                .map(Result::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void showLadder(Ladder ladder) {
        System.out.print(ladder);
    }

    public void printUsers(List<User> users) {
        StringBuilder builder = new StringBuilder();
        for (User user : users) {
            builder.append(user);
        }
        System.out.println(builder);
    }

    public void printResults(List<Result> results) {
        StringBuilder builder = new StringBuilder();
        for (Result result : results) {
            builder.append(result);
        }
        System.out.println(builder);
    }
}

