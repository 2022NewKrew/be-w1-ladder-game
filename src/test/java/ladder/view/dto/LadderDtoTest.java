package ladder.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderDtoTest {

    @Test
    @DisplayName("DTO 생성 후 getter가 정상적으로 값을 반환하는지 확인하는 테스트")
    void test_dto_getter() {
        //given
        String nameList = "sumin, mino, andy";
        int height = 100;

        //when
        LadderDto ladderDto = new LadderDto(nameList, height);

        //then
        assertEquals(ladderDto.getHeight(), height);
        assertEquals(ladderDto.getNameList(), nameList);
    }

}