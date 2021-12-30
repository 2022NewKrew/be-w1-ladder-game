package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LadderRowTest {

    @Test
    @DisplayName("연속으로 가로줄이 생기는 경우는 없어야 한다.")
    public void ladderRowTest() {
        // given
        int ladderWidth = 10;
        LadderRow ladderRow;

        // when
        ladderRow = new LadderRow(ladderWidth);
        List<LadderCell> row = ladderRow.getRow();

        // then
        LineType previousLineType = LineType.EMPTY_LINE;
        for (LadderCell ladderCell : row) {
            LineType currentLineType = ladderCell.getLine();

            if (previousLineType == LineType.HORIZONTAL_LINE && currentLineType == LineType.HORIZONTAL_LINE) {
                fail("연속된 가로줄이 올 수 없습니다.");
            }

            previousLineType = ladderCell.getLine();
        }
    }

    @Test
    @DisplayName("여러번 반복했을 때도 연속으로 가로줄이 생기는 경우는 없어야 한다.")
    public void ladderRowLoopTest() {
        // given
        int ladderWidth = 10;
        List<LadderRow> ladderRows = new ArrayList<>();

        // when
        for (int i = 0; i < 100; i++) {
            ladderRows.add(new LadderRow(ladderWidth));
        }

        // then
        for (LadderRow ladderRow : ladderRows) {
            List<LadderCell> row = ladderRow.getRow();

            LineType previousLineType = LineType.EMPTY_LINE;
            for (LadderCell ladderCell : row) {
                LineType currentLineType = ladderCell.getLine();

                if (previousLineType == LineType.HORIZONTAL_LINE && currentLineType == LineType.HORIZONTAL_LINE) {
                    fail("연속된 가로줄이 올 수 없습니다.");
                }

                previousLineType = ladderCell.getLine();
            }
        }
    }
}