package service;

import dto.Ladder;
import dto.LadderInputInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RandomLadderGeneratorTest {
    LadderGenerator ladderGenerator = new RandomLadderGenerator();

    @Test
    @DisplayName("이름의 공백이 의도된대로 나오는지 확인합니다.")
    public void ladderNameSpaceTest() {
        //given
        LadderInputInfo ladderInputInfo = new LadderInputInfo(4, 5, Arrays.asList("pobi", "honux", "crong", "jk"));
        // when
        Ladder ladder = ladderGenerator.buildLadder(ladderInputInfo);
        //then
        System.out.println(ladder);
    }

}