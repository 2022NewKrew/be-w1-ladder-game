import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Users {

    private final List<User> users;

    public Users(String[] peopleNames) {
        users = initializeUsers(peopleNames);
    }

    private List<User> initializeUsers(String[] peopleNames) {
        return Arrays.stream(peopleNames)
                .map(User::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getNumberOfUser() {
        return users.size();
    }

    public List<User> getUserList() {
        return users;
    }

}
