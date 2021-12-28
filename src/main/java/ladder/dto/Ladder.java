package ladder.dto;

import java.util.List;

public class Ladder {
    private int width;
    private int height;
    private List<String> participants;
    private List<LadderFloor> ladder;

    public Ladder(List<String> participants, int height, List<LadderFloor> ladder) {
        this.width = participants.size();
        this.participants = participants;
        this.height = height;
        this.ladder = ladder;
    }

    public void print() {
        participants.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
        ladder.stream().forEach(floor -> System.out.println("\t" + floor));
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getParticipants() {
        return participants;
    }
}


