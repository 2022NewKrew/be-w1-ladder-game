package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    public void testSuccessWhenAdd(){
        //given
        GameResult gameResult = new GameResult();
        String userName1 = "hello";
        Reward reward1 = new Reward("5000");

        //when
        gameResult.addResult(userName1, reward1);

        //then
        assertNotEquals(GameResult.NO_USER_EXCEPTION_MESSAGE, gameResult.getResult(userName1));
    }
}