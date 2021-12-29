package data;

import java.util.Arrays;
import java.util.List;

public class LadderInfo {
    private final int height;
    private final List<String> participants;

    public LadderInfo(String[] participants, int height) {
        this.participants = Arrays.asList(participants);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return participants.size();
    }

    public List<String> getParticipants() {
        return participants;
    }
}
