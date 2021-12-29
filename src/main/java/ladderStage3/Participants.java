package ladderStage3;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    private final List<Participant> participants = new ArrayList<>();

    private static final String COMMA = ",";

    public Participants(String names) {
        for(String name : splitNames(names)) {
            participants.add(new Participant(name));
        }
    }

    private String[] splitNames(String names) {
        return names.split(COMMA);
    }

    public int size() {
        return participants.size();
    }

    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        participants.forEach(participant -> names.add(participant.getName()));
        return names;
    }
}
