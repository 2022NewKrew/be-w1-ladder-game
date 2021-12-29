import java.util.ArrayList;
import java.util.List;

public class LadderManager {
    private final Ladder ladder;
    private final ArrayList<String> users;

    public LadderManager(String userNames, int height) {
        users = new ArrayList<>(List.of(userNames.split(",")));
        ladder = new Ladder(users.size(), height);
    }

    public void startLadder(){
        users.forEach(user -> System.out.printf("%5s ", user));
        System.out.println();
        System.out.println(ladder.printLadder());
    }
}
