import java.awt.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {

    private final List<String> participants;
    private final Ladder ladder;
    private final DisplayLadder renderer;

    LadderGame(List<String> participants, Ladder ladder, DisplayLadder renderer) {
        this.participants = Collections.unmodifiableList(participants);
        this.ladder = ladder;
        this.renderer = renderer;
    }

    public void displayLadder() {
        StringBuilder sb = new StringBuilder();
        participants.forEach(participant -> {
            sb.append(String.format("%-6s", participant));
        });
        System.out.println(sb);
        renderer.display(ladder);
    }
}
