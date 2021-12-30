package step3LadderGame.domain.ladder;

import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.LadderGenerator;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step2LadderGame.exception.ladderException.TypeMissMatchException;
import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class
RandomLadderIncludeParticipantsGeneratorTest {

    @Test
    @DisplayName("이름이 포함된 사다리가 성공적으로 생성되는 테스트")
    void generate() {
        // given
        final List<String> participants = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final int height = 5;
        final int width = (participants.size() * 2) - 1;

        final LadderConfig ladderConfig = new LadderIncludeParticipantsConfig(participants, height);
        final LadderGenerator ladderGenerator = new RandomLadderIncludeParticipantsGenerator();

        // when
        final Ladder ladder = ladderGenerator.generate(ladderConfig);

        // then
        assertEquals(height, ladder.getHeight());
        assertEquals(width, ladder.getWidth());
        assertEquals(LadderIncludeParticipants.class, ladder.getClass());

        final List<String> actualParticipantsList = ((LadderIncludeParticipants) ladder).getParticipants();
        assertIterableEquals(participants, actualParticipantsList);
    }

    @Test
    @DisplayName("타입이 맞지 않은 LadderConfig 입력시 에러 반환")
    void generateThrowException() {
        // given
        final LadderConfig ladderConfig = new LadderConfig(3, 5);
        final LadderGenerator ladderGenerator = new RandomLadderIncludeParticipantsGenerator();

        // when then'
        assertThrows(TypeMissMatchException.class, () -> ladderGenerator.generate(ladderConfig));
    }
}