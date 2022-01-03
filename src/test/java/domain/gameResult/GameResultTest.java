package domain.gameResult;

import dao.GameResultDAO;
import dao.LadderDAO;
import dto.gameResultDto.AllResultDTO;
import dto.ladderDto.LadderDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utility.RandomGenerator;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    private static final int TEST_FRAME_LENGTH = 5;
    private static final int TEST_HEIGHT = 10;
    private static final int TEST_SEED = 5;
    private static final LadderDAO ladderDAO = new LadderDAO();
    GameResultDAO gameResultDAO = new GameResultDAO();

    @BeforeAll
    static void generateLadder(){
        RandomGenerator.setSeed(TEST_SEED);
        ladderDAO.saveLadder(TEST_FRAME_LENGTH, TEST_HEIGHT);
    }

    @DisplayName("올바른 결과값을 가지고 게임결과를 생성했을 때 올바른 결과값과 생성된 결과값이 같다.")
    @ParameterizedTest
    @MethodSource("expected")
    void calculateResultTest(Map<String, String> expected, List<String> users, List<String> results){
        //Give : 기대값, 유저 목록, 결과 목록
        LadderDTO ladderDTO = ladderDAO.getLadderDTO();
        //When
        gameResultDAO.saveGameResult(ladderDTO, users, results);
        //Then
        assertThat(isSame(gameResultDAO.getAllResultDto(), expected)).isTrue();

    }

    private boolean isSame(AllResultDTO allResultDTO, Map<String, String> expectedEntries){
        if (allResultDTO.getResults().size() != expectedEntries.size()){
            return false;
        }

        if(allResultDTO.getResults().stream().allMatch(entry-> entry.getValue() == expectedEntries.get(entry.getKey()))){
            return true;
        }

        return false;
    }

    private static Stream<Arguments> expected() {

        Map<String, String> expectedMap = getExpectedMap();
        List<String> users = getUsers();
        List<String> results = getResults();

        return Stream.of(
                Arguments.of(
                        expectedMap,
                        users,
                        results
                )
        );
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
