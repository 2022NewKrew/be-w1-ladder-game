package ladder;

import dto.LadderInputInfo;
import ladder.domain.LadderFloor;

import java.util.List;

public class LadderImpl implements Ladder {
    private int width;
    private int height;
    private List<String> participants;
    private List<String> results;
    private List<LadderFloor> ladder;


    //inner class로 builder
    protected LadderImpl(LadderInputInfo ladderInputInfo, List<LadderFloor> ladder) {
        this.width = ladderInputInfo.getWidth();
        this.participants = ladderInputInfo.getParticipants();
        this.height = ladderInputInfo.getHeight();
        this.ladder = ladder;
    }

    public void print() {
        participants.forEach(name -> System.out.printf("%6s", name));
        System.out.println();
        ladder.stream().forEach(floor -> System.out.println("\t" + floor));
        results.forEach(res -> System.out.printf("%6s", res));
        System.out.println();
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