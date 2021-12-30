package ladder;

import exception.InvalidBridgeException;
import exception.OutOfInputStringException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    public void 참가자_이름길이_5이하() throws Exception {
        //given
        LadderSimpleGame ladderSimpleGame = new LadderSimpleGame();

        //when
        String[] participants = {"AAAAA", "B", "CCC", "DD", "EEEEE"};
        ladderSimpleGame.setParticipants(participants);

        //then
        ladderSimpleGame.checkInvalidNameLength();
    }

    @Test
    public void 참가자_이름길이_5초과() throws Exception {
        //given
        LadderSimpleGame ladderSimpleGame = new LadderSimpleGame();

        //when
        String[] participants = {"AAAAAA", "B", "CCC", "DD", "EEEEE"};
        ladderSimpleGame.setParticipants(participants);

        //then
        assertThrows(OutOfInputStringException.class, ladderSimpleGame::checkInvalidNameLength);
    }
}