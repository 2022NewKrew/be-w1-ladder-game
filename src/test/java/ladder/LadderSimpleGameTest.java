package ladder;

import com.sun.org.apache.xpath.internal.operations.Bool;
import exception.InvalidBridgeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderSimpleGameTest {

    @Test
    public void 연속으로_다리_O() throws Exception {
        //given
        LadderSimpleGame ladderSimpleGame = new LadderSimpleGame();

        //when
        int numberOfParticipants = 4;
        int ladderHeight = 3;

        List<List<Boolean>> bridge = new ArrayList<>();

        bridge.add(Arrays.asList(true, true, false));
        bridge.add(Arrays.asList(false,false,false));
        bridge.add(Arrays.asList(false,false,false));

        ladderSimpleGame.setBridge(bridge);

        //then
        assertThrows(InvalidBridgeException.class, ladderSimpleGame::checkInvalidBridge);
    }

    @Test
    public void 연속으로_다리_X() throws Exception {
        //given
        LadderSimpleGame ladderSimpleGame = new LadderSimpleGame();

        //when
        int numberOfParticipants = 4;
        int ladderHeight = 3;

        List<List<Boolean>> bridge = new ArrayList<>();

        bridge.add(Arrays.asList(true, false, true));
        bridge.add(Arrays.asList(false,false,false));
        bridge.add(Arrays.asList(true,false,false));

        ladderSimpleGame.setBridge(bridge);

        //then
        ladderSimpleGame.checkInvalidBridge();
    }
}