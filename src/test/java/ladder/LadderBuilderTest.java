package ladder;

import ladder.dto.Ladder;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderBuilderTest {

    LadderBuilder ladderBuilder = new LadderBuilder();
    @Test
    void 사다리생성후_크기확인() {
        // given
        final int height = 5;
        final List<String> participants = Arrays.asList(new String[]{"name", "js", "java"});

        // when
        Ladder ladder = ladderBuilder.createLadder(participants, height);

        // then
        assertThat(ladder.getWidth()).isEqualTo(participants.size());
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    public void 잘못된_width(){
        //given
        final int height = 5;
        final List<String> participants = Arrays.asList(new String[]{});

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderBuilder.createLadder(participants, height));
    }

    @Test
    public void 잘못된_height(){
        //given
        final int height = 0;
        final List<String> participants = Arrays.asList(new String[]{"gosl","java","one","some"});

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> ladderBuilder.createLadder(participants, height));
    }

}