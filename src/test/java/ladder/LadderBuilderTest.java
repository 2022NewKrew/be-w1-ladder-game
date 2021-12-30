package ladder;

import dto.LadderInputInfo;
import exception.LadderInfoMismatchException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderBuilderTest {
    LadderBuilder ladderBuilder = LadderImpl.randomLadderBuilder;

    @Test
    void 사다리생성후_크기확인() {
        // given
        final int height = 5;
        final List<String> participants = Arrays.asList(new String[]{"name", "js", "java"});
        final List<String> results = Arrays.asList(new String[]{"3", "2", "1"});

        // when
        Ladder ladder = ladderBuilder.createLadder(new LadderInputInfo(participants.size(), height, participants, results));

        // then
        assertThat(ladder.getWidth()).isEqualTo(participants.size());
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    void 사다리생성후_정상출력확인() {
        // given
        final int height = 5;
        final List<String> participants = Arrays.asList(new String[]{"name", "js", "java", "asd", "qwert","poiur"});
        final List<String> results = Arrays.asList(new String[]{"3", "2", "1","3", "2", "1"});

        // when
        Ladder ladder = ladderBuilder.createLadder(new LadderInputInfo(participants.size(), height, participants, results));

        // then
        ladder.print();
    }

    @Test
    public void 잘못된_width() {
        //given
        final int height = 5;
        final List<String> participants = Arrays.asList(new String[]{});
        final List<String> results = Arrays.asList(new String[]{});

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderBuilder.createLadder(new LadderInputInfo(participants.size(), height, participants, results)));
    }

    @Test
    public void 잘못된_height() {
        //given
        final int height = 0;
        final List<String> participants = Arrays.asList(new String[]{"gosl", "java", "one", "some"});
        final List<String> results = Arrays.asList(new String[]{"꽝","꽝","꽝","당첨"});

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderBuilder.createLadder(new LadderInputInfo(participants.size(), height, participants, results)));
    }

    @Test
    void 참여자인원_보상갯수_불일치() {
        // given
        final int height = 10;
        final List<String> participants = Arrays.asList(new String[]{"gosl", "java", "one", "some"});
        final List<String> results = Arrays.asList(new String[]{"꽝","꽝","당첨"});

        // when

        // then
        assertThrows(LadderInfoMismatchException.class, () -> ladderBuilder.createLadder(new LadderInputInfo(participants.size(), height, participants, results)));
    }

}