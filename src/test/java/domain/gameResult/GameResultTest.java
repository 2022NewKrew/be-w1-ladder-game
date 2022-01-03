package domain.gameResult;

import domain.ladder.Ladder;
import dto.gameResultDto.AllResultDTO;
import dto.gameResultDto.TargetResultDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utility.RandomGenerator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private static final int TEST_FRAME_LENGTH = 5;
    private static final int TEST_HEIGHT = 10;
    private static final int TEST_SEED = 5;

    private static Ladder ladder;
    private static GameResult gameResult;
    public static final String EXPECTED_RESULT = "1";
    public static final String TARGET = "a";

    @BeforeAll
    static void generateLadder() {
        RandomGenerator.setSeed(TEST_SEED);
        Ladder.makeLadder(TEST_FRAME_LENGTH, TEST_HEIGHT);
        ladder = Ladder.getInstance();
    }

    @DisplayName("올바른 결과값을 가지고 게임결과를 생성했을 때 올바른 결과값과 생성된 결과값이 같다.")
    @Test
    void calculateResultTest() {
        //Give : 기대값, 유저 목록, 결과 목록
        Map<String, String> expected = getExpectedMap();
        List<String> users = getUsers();
        List<String> results = getResults();
        //When
        GameResult.makeGameResult(ladder.getBridgeIndexes(), users, results);
        gameResult = GameResult.getInstance();
        //Then
        assertThat(isSame(new AllResultDTO(gameResult.getResult().entrySet()), expected)).isTrue();

    }

    @DisplayName("올바른 결과값을 가지고 게임결과를 생성했을 때 조회하고 싶은 대상의 결과가 올바른 결과와 같다.")
    @Test
    void targetResultTest() {
        //Give : 기대값, 유저 목록, 결과 목록
        List<String> users = getUsers();
        List<String> results = getResults();
        //When
        GameResult.makeGameResult(ladder.getBridgeIndexes(), users, results);
        gameResult = GameResult.getInstance();
        //Then
        assertThat(isSame(new TargetResultDTO(gameResult.getResult().get(TARGET)), EXPECTED_RESULT)).isTrue();

    }

    private boolean isSame(AllResultDTO allResultDTO, Map<String, String> expectedEntries) {
        if (allResultDTO.getResults().size() != expectedEntries.size()) {
            return false;
        }

        if (allResultDTO.getResults().stream().allMatch(entry -> entry.getValue() == expectedEntries.get(entry.getKey()))) {
            return true;
        }

        return false;
    }

    private boolean isSame(TargetResultDTO targetResultDTO, String result) {
        return targetResultDTO.getResult() == result;
    }

    private static Map<String, String> getExpectedMap() {
        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("a", "1");
        expectedMap.put("b", "3");
        expectedMap.put("c", "5");
        expectedMap.put("d", "6");
        expectedMap.put("e", "4");
        expectedMap.put("f", "2");
        return expectedMap;
    }

    private static List<String> getUsers() {
        return Arrays.asList("a", "b", "c", "d", "e", "f");
    }

    private static List<String> getResults() {
        return Arrays.asList("1", "2", "3", "4", "5", "6");
    }
}
