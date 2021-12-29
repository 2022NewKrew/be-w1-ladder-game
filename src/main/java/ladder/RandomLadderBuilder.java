package ladder;

import ladder.domain.Ladder;
import ladder.domain.LadderFloor;
import ladder.domain.LadderFloorProxy;
import dto.LadderInputInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderBuilder implements LadderBuilder {
    private static Random random = new Random();
    private LadderInputInfo ladderInfo;

    public RandomLadderBuilder() {
    }

    public Ladder createLadder(LadderInputInfo ladderInfo) throws IllegalArgumentException {
        this.ladderInfo = ladderInfo;
        if (ladderInfo.getWidth() < 1) throw new IllegalArgumentException("참여인원은 한명 이상입니다.");
        if (ladderInfo.getHeight() < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
        return new Ladder(ladderInfo, buildLadder());
    }

    private List<LadderFloor> buildLadder() {
        List<LadderFloor> ladder = new ArrayList<>(ladderInfo.getHeight());
        for (int i = 0; i < ladderInfo.getHeight(); i++) {
            ladder.add(new LadderFloorProxy(createFloorConnectInfo()));
        }
        return ladder;
    }

    private List<Boolean> createFloorConnectInfo() {
        List<Boolean> connectInfo = new ArrayList<>();
        Boolean isConnectedBefore = false;
        for (int i = 1; i < ladderInfo.getWidth(); i++) {
            Boolean decideCurrentConnect = decideConnect();
            connectInfo.add(!isConnectedBefore && decideCurrentConnect);
            isConnectedBefore = !isConnectedBefore && decideCurrentConnect;
        }
        return connectInfo;
    }

    private Boolean decideConnect() {
        return random.nextBoolean();
    }
}
