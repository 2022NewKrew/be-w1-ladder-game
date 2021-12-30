import domain.Ladder;
import domain.Participant;
import view.LadderGameView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private final List<Participant> participants;
    private final Ladder ladder;
    private final LadderGameView ladderGameView;

    public LadderGame(String[] names, int height) {
        participants = Arrays.stream(names).map(Participant::new).collect(Collectors.toList());
        ladder = new Ladder(height, participants.size());
        ladderGameView = new LadderGameView();
    }

    public void printInformation() {
        List<String> names = participants.stream().map(Participant::getName).collect(Collectors.toList());
        ladderGameView.printLadderGameInformation(names, ladder.toString());
    }
}
