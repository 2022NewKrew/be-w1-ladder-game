package ladder.domain;

import dto.LadderInputInfo;

import java.util.List;

public class Ladder {
    private int width;
    private int height;
    private List<String> participants;
    private List<LadderFloor> ladder;

    public Ladder(LadderInputInfo ladderInputInfo, List<LadderFloor> ladder) {
        this.width = ladderInputInfo.getWidth();
        this.participants = ladderInputInfo.getParticipants();
        this.height = ladderInputInfo.getHeight();
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


