package step5LadderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2LadderGame.domain.ladder.Ladder;
import step2LadderGame.domain.ladder.LadderGenerator;
import step2LadderGame.domain.ladderConfig.LadderConfig;
import step3LadderGame.domain.ladder.LadderIncludeParticipants;
import step3LadderGame.domain.ladder.RandomLadderIncludeParticipantsGenerator;
import step3LadderGame.domain.ladderConfig.LadderIncludeParticipantsConfig;
import step5LadderGame.domain.ladderConfig.LadderIncludeParticipantsAndResultsConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderIncludeParticipantsAndResultsGeneratorTest {

    @Test
    @DisplayName("이름과 결과가 포함된 사다리가 성공적으로 생성되는 테스트")
    void generate() {
        // given
        final List<String> participants = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final List<String> results = List.of("1", "2", "3", "4", "5");

        final int height = 5;
        final int width = (participants.size() * 2) - 1;

        final LadderConfig ladderConfig = new LadderIncludeParticipantsAndResultsConfig(participants, results, height);
        final LadderGenerator ladderGenerator = new RandomLadderIncludeParticipantsAndResultsGenerator();

        // when
        final Ladder ladder = ladderGenerator.generate(ladderConfig);

        // then
        assertEquals(height, ladder.getHeight());
        assertEquals(width, ladder.getWidth());
        assertEquals(LadderIncludeParticipantsAndResults.class, ladder.getClass());

        final List<String> actualParticipantsList = ((LadderIncludeParticipantsAndResults) ladder).getParticipants();
        assertIterableEquals(participants, actualParticipantsList);

        final List<String> actualResults = ((LadderIncludeParticipantsAndResults) ladder).getResults();
        assertIterableEquals(results, actualResults);
    }
}