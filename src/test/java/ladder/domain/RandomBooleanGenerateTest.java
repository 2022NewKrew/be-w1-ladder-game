package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomBooleanGenerateTest {

    @Test
    @DisplayName("true 연속 반환 여부 테스트")
    void check_continuous_true(){
        RandomBooleanGenerate randomBooleanGenerate = new RandomBooleanGenerate();
        assertFalse(randomBooleanGenerate.checkCanDraw() & randomBooleanGenerate.checkCanDraw()
                , () -> "연속적으로 true가 반환되면 안됨");
    }
}