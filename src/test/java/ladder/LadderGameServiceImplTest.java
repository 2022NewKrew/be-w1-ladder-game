package ladder;

import ladder.service.LadderGameServiceImpl;
import org.junit.jupiter.api.BeforeEach;

class LadderGameServiceImplTest {

    private LadderGameServiceImpl ladderGameService;

    @BeforeEach
    public void init() {
        ladderGameService = new LadderGameServiceImpl();
    }

}