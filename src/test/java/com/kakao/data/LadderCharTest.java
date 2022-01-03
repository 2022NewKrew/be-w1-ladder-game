package com.kakao.data;

import com.kakao.util.TextUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class LadderCharTest {

    @Test
    @DisplayName("함수 정상작동 테스트")
    void makeRepeatString() {
        String str = "123\\";
        int repeat = 3;
        String result = TextUtil.makeRepeatString(str, 3);

        final String answer = "123\\123\\123\\";
        assertThat(result)
                .isEqualTo(answer);
    }
}