package ladderGame.domain.ladder;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.domain.ladderConfig.LadderIncludeNamesConfig;
import ladderGame.exception.ladderException.TypeMissMatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderIncludeNamesGeneratorTest {

    @Test
    @DisplayName("이름이 포함된 사다리가 성공적으로 생성되는 테스트")
    void generate() {
        // given
        final List<String> nameList = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final int height = 5;
        final int width = (nameList.size() * 2) - 1;

        final LadderConfig ladderConfig = LadderIncludeNamesConfig.of(nameList, height);
        final LadderGenerator ladderGenerator = new RandomLadderIncludeNamesGenerator();

        // when
        Ladder ladder = ladderGenerator.generate(ladderConfig);

        // then
        assertEquals(height, ladder.getHeight());
        assertEquals(width, ladder.getWidth());
        assertEquals(LadderIncludeNames.class, ladder.getClass());

        List<String> actualNameList = ((LadderIncludeNames) ladder).getNameList();
        assertIterableEquals(nameList, actualNameList);
    }

    @Test
    @DisplayName("타입이 맞지 않은 LadderConfig 입력시 에러 반환")
    void generateThrowException() {
        // given
        final LadderConfig ladderConfig = LadderConfig.of(3, 5);
        final LadderGenerator ladderGenerator = new RandomLadderIncludeNamesGenerator();

        // when then
        assertThrows(TypeMissMatchException.class, () -> ladderGenerator.generate(ladderConfig));
    }
}