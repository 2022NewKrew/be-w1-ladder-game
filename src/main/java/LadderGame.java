import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Participant> participants;
    private final Ladder ladder;

    public LadderGame(String[] names, int height) {
        participants = Arrays.stream(names).map(Participant::new).collect(Collectors.toList());
        ladder = new Ladder(height, participants.size());
    }

    public void printInformation() {
        printParticipants();
        printLadder();
    }

    public void printParticipants() {
        List<String> names = participants.stream().map(Participant::getName).collect(Collectors.toList());
        System.out.println(String.join("", names));
    }

    public void printLadder() {
        System.out.println(ladder.toString());
    }
}
