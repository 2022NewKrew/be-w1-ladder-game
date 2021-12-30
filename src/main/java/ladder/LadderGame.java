package ladder;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LadderGame {
    private int numberOfParticipants;
    private int ladderHeight;
    private String[] participants;
    private List<List<Boolean>> bridge;
}
