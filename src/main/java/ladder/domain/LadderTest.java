package ladder.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    @Test
    void 참여자수테스트(){
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd,abcde";
        Long height = Long.valueOf(10);
        ladderObject.setValue(nameAry, height);

        assertTrue(ladderObject.getPeopleCount() == 5);
    }
}
