package com.kakao.data;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderCharTest {

    @Test
    void makeRepeatString() {
        String str = "123\\";
        int repeat = 3;
        String result = LadderChar.makeRepeatString(str, 3);

        final String answer = "123\\123\\123\\";
        assertThat(result)
                .isEqualTo(answer);
    }
}