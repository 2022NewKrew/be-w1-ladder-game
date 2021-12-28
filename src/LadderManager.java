import java.util.ArrayList;
import java.util.List;

public class LadderManager {
    private Ladder ladder;
    private ArrayList<String> users;

    public LadderManager(String people, int height) {
        users = new ArrayList<>(List.of(people.split(",")));
        ladder = new Ladder(users.size(), height);
    }

    public void startLadder(){
        users.forEach(str -> System.out.printf("%5s ", str));
        System.out.println();
        System.out.println(ladder.printLadder());
    }
}
