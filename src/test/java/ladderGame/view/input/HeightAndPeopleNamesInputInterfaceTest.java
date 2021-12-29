package ladderGame.view.input;

import ladderGame.domain.ladderConfig.LadderConfig;
import ladderGame.domain.ladderConfig.LadderIncludeNamesConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HeightAndPeopleNamesInputInterfaceTest {

    @Test
    @DisplayName("정상적인 입력에 대해서 성공적으로 LadderIncludeNamesConfig를 반환하는 테스트")
    void inputLadderConfig() {
        // given
        final List<String> nameList = List.of("aaaaa", "bbbb", "ccc", "dd", "e");
        final Integer height = 5;
        final String inputStr = String.join(",", nameList) + "\n" + height;

        final InputStream in = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(in);

        final InputInterface heightAndPeopleNamesInputInterface = new HeightAndPeopleNamesInputInterface();

        //when
        final LadderConfig ladderConfig = heightAndPeopleNamesInputInterface.inputLadderConfig();

        //then
        assertEquals(LadderIncludeNamesConfig.class, ladderConfig.getClass());
        assertEquals(height, ladderConfig.getHeight());

        List<String> actualNameList = ((LadderIncludeNamesConfig) ladderConfig).getNameList();
        assertIterableEquals(nameList, actualNameList);
    }
}