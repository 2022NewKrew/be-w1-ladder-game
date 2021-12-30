import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String[] peopleNames) {
        users = initializeUsers(peopleNames);
        validateEmptyUsers();
    }

    private List<User> initializeUsers(String[] peopleNames) {
        return Arrays.stream(peopleNames)
                .map(String::trim)
                .filter(name -> !name.equals(""))
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void validateEmptyUsers() {
        if (users.size() == 0) {
            throw new IllegalStateException("참여할 사람의 이름을 입력하셔야 합니다.");
        }
    }

    public int getNumberOfUser() {
        return users.size();
    }

    public void printUsers() {
        for (User user : users) {
            user.printUser();
        }
        SadariMapStatus.END.printStatus();
    }
}
