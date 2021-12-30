package ladder.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputInterfaceImplTest {
    @Test
    @DisplayName("사다리 결과 출력시 이름을 최대 5글자를 정확히 출력하는지 테스트")
    void nameOutputTest(){
        //given
        OutputInterfaceImpl outputImpl= new OutputInterfaceImpl();

        //when
        String over5 = outputImpl.makeNameLength5("aaaaaaaaa");
        String under5 = outputImpl.makeNameLength5("bb");

        //then
        assertEquals(over5, "aaaaa");
        assertEquals(under5, " bb  ");
        assertEquals(over5.length(), 5);
        assertEquals(under5.length(), 5);
    }

}