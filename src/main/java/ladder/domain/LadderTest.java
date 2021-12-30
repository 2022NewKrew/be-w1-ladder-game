package ladder.domain;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    @Test
    void 참여자수테스트() throws Exception {
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd,abcde";
        Long height = Long.valueOf(10);
        ladderObject.setValue(nameAry, height);

        assertTrue(ladderObject.getPeopleCount() == 5);
    }

    @Test
    void 연속적인_사다리_선_제거_테스트() throws Exception {
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd,abcde,a,b,c,d,e,a,b,c,d,e";
        Long height = Long.valueOf(100000); //테스트를 위해 높은 height로 지정
        ladderObject.setValue(nameAry, height);
        ladderObject.initLine();
        ladderObject.shuffle();


        Line[] lineStatus = ladderObject.getLineStatus();

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < lineStatus[i].value.size() - 1 ; j++){
                assertTrue(lineStatus[i].value.get(j) + 1 != lineStatus[i].value.get(j+1));
            }
        }

    }
}
