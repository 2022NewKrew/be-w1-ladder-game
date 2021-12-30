package bin.jayden.ladder_game.domain;

import java.util.List;

public class LadderInfo {
    private final int height;
    private final List<String> participants;

    public LadderInfo(List<String> participants, int height) {
        this.participants = participants;
        this.height = height;
    }

    public LadderInfo(String[] participants, int height) {
        this(List.of(participants), height);//Collections.unmodifiableList(Arrays.asList())라는 코드는 List.of로 대치된다.
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
