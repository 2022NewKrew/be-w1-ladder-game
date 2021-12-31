package domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RewardsTest {

    @Test
    public void testFailedWhenDifferentNumOfRewardAndNumOfPeople(){
        //given
        List<String> rewardStrings = List.of("꽝", "5000", "5000");

        //when
        IllegalArgumentException illegalArgumentException
                = assertThrows(IllegalArgumentException.class, ()->new Rewards(rewardStrings, 2));

        //then
        assertEquals(Rewards.MISMATCH_BETWEEN_REWARD_PEOPLE_EXCEPTION_MESSAGE, illegalArgumentException.getMessage());
    }

}