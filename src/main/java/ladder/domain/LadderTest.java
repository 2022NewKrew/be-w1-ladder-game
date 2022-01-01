package ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    @Test
    void 참여자수테스트() throws Exception {
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd,abcde";
        Long height = Long.valueOf(10);
       // ladderObject.setValue(nameAry, height);

        assertTrue(ladderObject.getPeopleCount() == 5);
    }

    @Test
    void 연속적인_사다리_선_제거_테스트() throws Exception {
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd,abcde,a,b,c,d,e,a,b,c,d,e";
        Long height = Long.valueOf(100000); //테스트를 위해 높은 height로 지정
       // ladderObject.setValue(nameAry, height);
        ladderObject.initLine();
        ladderObject.shuffle();


        List<Line> lineStatus = ladderObject.getLineStatus();

        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < lineStatus.get(i).value.size() - 1 ; j++){
                assertTrue(lineStatus.get(i).value.get(j) + 1 != lineStatus.get(i).value.get(j+1));
            }
        }
    }

    @Test
    void 잘못된_입력_테스트_names() throws Exception{
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,    abcd"; //공백발생 예외
        Long height = Long.valueOf(10);

        boolean isException = false;

        try{
           // ladderObject.setValue(nameAry, height);
        } catch(Exception e){
            isException = true;
        }

        assertTrue(isException);
    }

    @Test
    void 잘못된_입력_테스트_height() throws Exception{
        Ladder ladderObject = new Ladder();
        String nameAry = "a,ab,abc,abcd";
        Long height = Long.valueOf(0); //높이가 0인 예외사항

        boolean isException = false;

        try{
    //        ladderObject.setValue(nameAry, height);
        } catch(Exception e){
            isException = true;
        }

        assertTrue(isException);
    }
}
