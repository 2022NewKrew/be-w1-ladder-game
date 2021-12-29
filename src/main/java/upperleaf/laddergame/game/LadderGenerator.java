package upperleaf.laddergame.game;

import upperleaf.laddergame.domain.connector.ConnectionNumberPolicy;
import upperleaf.laddergame.domain.connector.RandomConnector;
import upperleaf.laddergame.domain.Ladder;

public class LadderGenerator {

    private final RandomConnector connector;
    private final ConnectionNumberPolicy connectionNumberPolicy;

    public LadderGenerator(RandomConnector connector, ConnectionNumberPolicy numberPolicy) {
        this.connector = connector;
        this.connectionNumberPolicy = numberPolicy;
    }

    /**
     * 사다리를 생성합니다.
     * 연결 생성 개수는 ConnectionNumberPolicy를 통해서 얻습니다.
     * 생성한 직후, Connector 이용해서 사다리(Ladder) 내 선(Line)들을 연결합니다.
     */
    public Ladder generate(GameStartInfo info) {
        Ladder ladder = new Ladder(info);
        int connectionNumber = connectionNumberPolicy.getConnectionNumber(ladder);
        for(int i = 0; i < connectionNumber; i++) {
            connector.connect(ladder);
        }
        return ladder;
    }
}
