package upperleaf.laddergame.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import upperleaf.laddergame.domain.Ladder;
import upperleaf.laddergame.domain.connector.RandomConnector;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LadderGeneratorTest {

    final int CONNECTION_NUMBER = 2;

    LadderGenerator generator;

    @BeforeEach
    void fixture() {
        RandomConnector connector = new RandomConnector(new Random(System.currentTimeMillis()));
        generator = new LadderGenerator(connector, new FixedConnectionNumberPolicy(CONNECTION_NUMBER));
    }

    @DisplayName("Generator를 통해 Ladder를 생성하면 초기화 및 연결 개수만큼 연결한다.")
    @Test
    void generatorTest() {
        GameStartInfoFactory factory = new GameStartInfoFactory();
        GameStartInfo info = factory.create();
        Ladder ladder = generator.generate(info);

        assertEquals(info.getGamePlayerNum(), ladder.getPlayerNum());
        assertEquals(info.getMaxLadderHeight(), ladder.getMaxLadderHeight());
        assertEquals(info.getPlayerNames(), ladder.getPlayerNames());

        assertEquals(CONNECTION_NUMBER, getConnectionNumberInLadder(ladder));
    }

    private int getConnectionNumberInLadder(Ladder ladder) {
        int sum = 0;
        for(int height = 0; height < ladder.getMaxLadderHeight(); height++) {
            sum += getConnectionNumberInHeight(ladder, height);
        }
        return sum;
    }

    private int getConnectionNumberInHeight(Ladder ladder, int height) {
        int sum = 0;
        for(int line = 0; line < ladder.getPlayerNum() - 1; line++) {
            sum += getConnectionNumberInLine(ladder, height, line);
        }
        return sum;
    }

    private int getConnectionNumberInLine(Ladder ladder, int height, int line) {
        if(ladder.isRightConnected(line, height)) {
            return 1;
        }
        return 0;
    }
}
