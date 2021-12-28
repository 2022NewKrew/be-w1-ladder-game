public class LadderGenerator {

    /**
    ** 사다리를 생성합니다.
    ** 생성한 직후, Connector 이용해서 사다리(Ladder) 내 선(Line)들을 연결합니다.
     */
    public Ladder generate(GameStartInfo info, RandomConnector connector) {
        Ladder ladder = new Ladder(info);
        int connectionNumber = (info.getGamePlayerNum() - 1) * (info.getMaxLadderHeight() / 2);
        for(int i = 0; i < connectionNumber; i++) {
            connector.connect(ladder);
        }
        return ladder;
    }
}
