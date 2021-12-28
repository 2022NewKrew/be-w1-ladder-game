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

    //LadderFloor은 Ladder, LadderBuilder 에서 사용하기 때문에 외부에서
    //LadderFloor에 대한 의존성이 생길 가능성을 배제하기 위해 getter를 두지 않았습니다.
}


