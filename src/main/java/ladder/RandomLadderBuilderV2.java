package ladder;

import dto.LadderInputInfo;
import ladder.domain.LadderFloor;
import ladder.domain.LadderFloorProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderBuilderV2 implements LadderBuilder {
    private static Random random = new Random();
    private LadderInputInfo ladderInfo;

    public RandomLadderBuilderV2() {
    }

    public class LadderImpl implements Ladder {
        private int width;
        private int height;
        private List<String> participants;
        private List<LadderFloor> ladder;

        //inner class로 builder
        private LadderImpl(LadderInputInfo ladderInputInfo, List<LadderFloor> ladder) {
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



    public Ladder createLadder(LadderInputInfo ladderInfo) throws IllegalArgumentException {
        this.ladderInfo = ladderInfo;
        if (ladderInfo.getWidth() < 1) throw new IllegalArgumentException("참여인원은 한명 이상입니다.");
        if (ladderInfo.getHeight() < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
        return new LadderImpl(ladderInfo, buildLadder());
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
