package main.java.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @DisplayName("문자열 가운데 정렬 test")
    @Test
    void centerString() {
        //given
        String str = "test";

        //when
        String newStr = Util.centerString(6,str);

        //then
        assertEquals(" test ",newStr);
    }
}