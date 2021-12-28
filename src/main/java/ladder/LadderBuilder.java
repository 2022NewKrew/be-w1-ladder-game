package ladder;

import ladder.dto.Ladder;
import ladder.dto.LadderFloor;
import vo.LadderInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderBuilder {
    private static Random random = new Random();
    private LadderInfo ladderInfo;

    public LadderBuilder() {}

    public Ladder createLadder(List<String> participants, int height) throws IllegalArgumentException{
        if(participants.size() < 1) throw new IllegalArgumentException("참여인원은 한명 이상입니다.");
        if(height < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
        ladderInfo = new LadderInfo(participants.size(), height);

        return new Ladder(participants, height, buildLadder());
    }

    // 스트림 써보기
    private List<LadderFloor> buildLadder(){
        List<LadderFloor> ladder = new ArrayList<>(ladderInfo.getHeight());
        for (int i = 0; i < ladderInfo.getHeight(); i++) {
            ladder.add(new LadderFloor(createFloorConnectInfo()));
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
