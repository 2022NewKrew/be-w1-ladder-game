package view;

import domain.Ladder;
import java.util.List;

public interface LadderGameInputManager {
    String getString();
    List<String> getParticipants();
    Ladder getLadder(List<String> participants);
    List<String> getResults();
    String getRequest();
}
