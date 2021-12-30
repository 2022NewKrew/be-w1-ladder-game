package ladder.view;

import ladder.domain.Ladder;

import java.util.List;

public interface OutputInterface {
    void printParticipants(List<String> participants);
    void printLadder(Ladder ladder);
}
