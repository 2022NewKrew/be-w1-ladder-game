package ladder;

import dto.LadderInputInfo;
import exception.LadderInfoMismatchException;
import ladder.domain.LadderFloor;
import ladder.domain.LadderFloorProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderImpl implements Ladder{

    public static RandomLadderBuilder randomLadderBuilder = new RandomLadderBuilder();

    private int width;
    private int height;
    private List<String> participants;
    private List<String> results;
    private List<LadderFloor> ladder;

    /**
     * Inner Class
     */
    public static class RandomLadderBuilder implements LadderBuilder {
        private static Random random = new Random();
        private LadderInputInfo ladderInfo;

        public Ladder createLadder(LadderInputInfo ladderInfo) throws IllegalArgumentException, LadderInfoMismatchException {
            this.ladderInfo = ladderInfo;
            if (ladderInfo.getWidth() < 1) throw new IllegalArgumentException("참여인원은 한명 이상입니다.");
            if (ladderInfo.getHeight() < 1) throw new IllegalArgumentException("높이가 잘못 입력되었습니다.");
            if (ladderInfo.getParticipants().size() != ladderInfo.getResults().size()) throw new LadderInfoMismatchException("참여자 인원과 결과 갯수는 동일해야 합니다.");
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


    private LadderImpl(LadderInputInfo ladderInputInfo, List<LadderFloor> ladder) {
        this.width = ladderInputInfo.getWidth();
        this.height = ladderInputInfo.getHeight();
        this.participants = ladderInputInfo.getParticipants();
        this.results = ladderInputInfo.getResults();
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

    public List<String> getResults() {
        return results;
    }

    public List<LadderFloor> getLadder() {
        return ladder;
    }
}