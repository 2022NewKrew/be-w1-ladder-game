package ladder.domain;

import ladder.service.LadderService;
import ladder.view.dto.LadderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    @DisplayName("이름으로 5글자 이상을 입력한 경우 에러 처리 테스트")
    void tset_input_validation() {
        // given
        String nameList = "sumin, andy, justin";
        int height = 10;
        LadderDto ladderDto = new LadderDto(nameList, height);

        assertThrows(IllegalArgumentException.class,
                () -> LadderService.runLadderGame(ladderDto),
                "이름은 5글자 이하로 입력해주세요");
    }
}
