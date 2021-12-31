package step_5.domain;

import step_5.dto.LadderInfo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderBuilder {
    private final Random random = new Random();

    protected LadderBuilder() {}

    protected Ladder build(LadderInfo ladderInfo) {
        final int width = ladderInfo.getWidth() - 1; // n 명의 참가자가 있으면 n-1 개의 연결 관계만 나타내면 됨
        final int height = ladderInfo.getHeight();

        List<LadderConnection> ladderConnections = buildConnections(width, height);

        return new Ladder(ladderConnections);
    }

    private List<LadderConnection> buildConnections(int width, int height) {
        return IntStream.range(0, height)
                .mapToObj(row -> buildConnection(width))
                .collect(Collectors.toList());
    }

    private LadderConnection buildConnection(int width) {
        LadderConnection ladderConnection = LadderConnection.initBySize(width);
        IntStream.range(0, width)
                .forEach(index -> ladderConnection.setConnect(index, decideConnection(ladderConnection, index)));
        return ladderConnection;
    }

    private Boolean decideConnection(LadderConnection ladderConnection, int index) {
        if (ladderConnection.isLeftConnected(index))
            return false;
        return random.nextBoolean();
    }
}
