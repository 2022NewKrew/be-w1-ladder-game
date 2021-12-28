package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderBuilder {
    private static Random random = new Random();
    private LadderInfo ladderInfo;

    public LadderBuilder() {
    }

    public Ladder createLadder(int width, int height) throws IllegalArgumentException{
        if(width < 1) throw new IllegalArgumentException("참여인원이 잘못 입력되었습니다.");
        if(height < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
        ladderInfo = new LadderInfo(width, height);

        return new Ladder(width, height, buildLadder());
    }


    private List<String> buildLadder(){
        List<String> ladder = new ArrayList<>(ladderInfo.getHeight());
        for(int i = 0; i < ladderInfo.getHeight(); i++) {
            ladder.add(createFloor());
        }
        return ladder;
    }

    private String createFloor() {
        StringBuilder floor = new StringBuilder("|");
        for (int i = 1; i < ladderInfo.getWidth(); i++) {
            floor.append(decideConnect() ? " |" : "-|");
        }
        return floor.toString();
    }

    private Boolean decideConnect() {
        return random.nextBoolean();
    }
}
