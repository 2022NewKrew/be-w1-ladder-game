package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import ladder.domain.Result;
import ladder.domain.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Engine {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";
    private Map<UUID, Result> userResultHashMap;
    private List<User> users;
    private List<Result> results;


    public List<User> inputUsers() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] inputList = scanner.nextLine().split(DELIMITER);

        users = Arrays.stream(inputList)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
        return users;
    }

    public List<Result> inputResult() {
        System.out.printf("실행 결과를 입력하세요. (결과는 쉼표(%s)로 구분하세요)\n", DELIMITER);
        String[] inputList = scanner.nextLine().split(DELIMITER);

        results = Arrays.stream(inputList)
                .map(Result::new)
                .collect(Collectors.toUnmodifiableList());
        return results;
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(scanner.nextLine());
    }

    public void inputUserResult() {
        final String EXIT_KEY = "춘식이";
        final String PRINT_ALL_KEY = "all";
        while (true) {
            System.out.println("결과를 보고 싶은 사람은?");
            String name = scanner.nextLine();

            if (name.equals(EXIT_KEY)) return;
            if (name.equals(PRINT_ALL_KEY)) {
                printAllUserResult();
                continue;
            }
            Optional<User> foundUser = findUser(name);
            foundUser.ifPresent(user -> System.out.println(userResultHashMap.get(user.getId())));
        }
    }

    public void printAllUserResult() {
        System.out.println("실행 결과");
        users.forEach(user -> System.out.println(user.getName() + ":" + userResultHashMap.get(user.getId())));
    }

    public Optional<User> findUser(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    public void printUsers() {
        StringBuilder builder = new StringBuilder();
        users.forEach(builder::append);
        System.out.println(builder);
    }

    public void printResults() {
        StringBuilder builder = new StringBuilder();
        results.forEach(builder::append);
        System.out.println(builder);
    }

    public void run(Ladder ladder, List<User> users, List<Result> results) {
        userResultHashMap = new HashMap<>();
        List<LadderRow> rows = ladder.getRows();
        IntStream.range(0, users.size()).forEach(i -> {
            int bridgeIdx = i;
            for (LadderRow row : rows) {
                bridgeIdx = row.getNextRowIndex(bridgeIdx);
            }
            userResultHashMap.put(users.get(i).getId(), results.get(bridgeIdx));
        });
    }
}

