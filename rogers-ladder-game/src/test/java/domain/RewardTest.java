package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RewardTest {

    @Test
    public void testFailedWhenSpellingDifferent꽝(){
        //given
        String amountString1 = "꽝꽝";
        String amountString2 = "hello";

        //when
        IllegalArgumentException illegalArgumentException1
                = assertThrows(IllegalArgumentException.class, ()->new Reward(amountString1));
        IllegalArgumentException illegalArgumentException2
                = assertThrows(IllegalArgumentException.class, ()->new Reward(amountString2));

        //then
        assertEquals(illegalArgumentException1.getMessage(), Reward.MONEY_PATTERN_EXCEPTION_MESSAGE);
        assertEquals(illegalArgumentException2.getMessage(), Reward.MONEY_PATTERN_EXCEPTION_MESSAGE);
    }
}