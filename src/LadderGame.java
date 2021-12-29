import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<String> participants;
    private final Ladder ladder;
    private final DisplayLadder renderer;

    LadderGame(List<String> participants, int height) {
        this.participants = List.copyOf(participants);
        ladder = new Ladder(participants.size(), height);
        renderer = new StandardOutDisplayLadder();
    }

    public void displayLadder() {
        //TODO:바꾸기
        StringBuilder sb = new StringBuilder();
        for(String participant : participants) {
            sb.append(participant);
            IntStream.range(0, 6-participant.length()).forEach(e -> sb.append(' '));
        }
        System.out.println(sb);
        renderer.display(ladder);
    }
}
