package service;

import domain.sadari.SadariMap;
import domain.sadari.SadariMapStatus;
import domain.sadari.result.GameResult;
import domain.sadari.result.SadariResults;
import domain.user.Users;
import domain.user.dto.UserDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SadariFinderImplTest {

    SadariFinder sadariFinder;

    @BeforeEach
    void setUp() {
        Users users = new Users(List.of(new UserDto("a", 1),
                new UserDto("b", 2), new UserDto("c", 3)));
        SadariResults sadariResults = new SadariResults(new String[]{"꽝", "당첨", "꽝"});
        SadariMap sadariMap = createTestSadariMap();
        sadariFinder = new SadariFinderImpl(users, sadariMap, sadariResults);
    }

    private SadariMap createTestSadariMap() {
        SadariMap sadariMap = new SadariMap(3, 5);
        sadariMap.storeSadariMapStatus(0, SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(0,SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(0,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(0,SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(0,SadariMapStatus.SADARI_BORDER);

        sadariMap.storeSadariMapStatus(1,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(1,SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(1,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(1,SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(1,SadariMapStatus.SADARI_BORDER);

        sadariMap.storeSadariMapStatus(2,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(2,SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(2,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(2,SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(2,SadariMapStatus.SADARI_BORDER);

        sadariMap.storeSadariMapStatus(3,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(3,SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(3,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(3,SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(3,SadariMapStatus.SADARI_BORDER);

        sadariMap.storeSadariMapStatus(4,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(4,SadariMapStatus.EMPTY);
        sadariMap.storeSadariMapStatus(4,SadariMapStatus.SADARI_BORDER);
        sadariMap.storeSadariMapStatus(4,SadariMapStatus.SADARI_LINE);
        sadariMap.storeSadariMapStatus(4,SadariMapStatus.SADARI_BORDER);
        return sadariMap;
    }

    @Test
    void 개별_사다리타기_시작() {
        GameResult gameResult = sadariFinder.find("c");
        assertEquals("c", gameResult.getUserName());
        assertEquals("당첨", gameResult.getResultName());
    }

    @Test
    void 전체_사다리타기_시작() {
        List<GameResult> gameResults = sadariFinder.findAll();
        assertEquals("a",gameResults.get(0).getUserName());
        assertEquals("꽝",gameResults.get(0).getResultName());
        assertEquals("b",gameResults.get(1).getUserName());
        assertEquals("꽝",gameResults.get(1).getResultName());
        assertEquals("c",gameResults.get(2).getUserName());
        assertEquals("당첨",gameResults.get(2).getResultName());
    }

}