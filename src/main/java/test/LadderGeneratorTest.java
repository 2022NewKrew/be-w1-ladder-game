package test;

import domain.Ladder;
import domain.LadderGenerator;
import domain.LadderLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {
    @Test
    @DisplayName("사다리 가로선 다음은 공백인지 테스트")
    void 중복_가로_확인() {
        // given(ladder 주어짐)
        LadderGenerator ladderGenerator = new LadderGenerator(3, 5);
        Ladder ladder = ladderGenerator.createLadder();

        // when(사다리 가로선이 true 일때)
        for (LadderLine line : ladder.getLadder()) {
            for (int indexLinePiece = 0; indexLinePiece < line.getLadderLinePieces().size() - 1; indexLinePiece++) {
                if (line.getLadderLinePieces().get(indexLinePiece).getPiece()) {
                    // then
                    Assertions.assertEquals(line.getLadderLinePieces().get(indexLinePiece + 1).getPiece(), false);
                }
            }
        }
    }
}