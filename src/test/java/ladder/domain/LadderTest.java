package ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {


    @Test
    void 이름에_공백이_포함되면_예외가_발생한다(){
        //given
        String nameSample = "a,ab,abc,abcd,   abcde";
        Long height = Long.valueOf(10);


        //when
        //Ladder ladderObject = new Ladder(nameSample, height); //이름에 공백이 들어간 객체생성시


        //then
        assertThatThrownBy(() -> {
            Ladder ladderObject = new Ladder(nameSample, height);
        }).isInstanceOf(Exception.class).hasMessageContaining("Space_Inside_Name");
    }

    @Test
    void 연속적인_사다리_선_제거_테스트() {

        //given
        String nameAry = "a,ab,abc,abcd,abcde,a,b,c,d,e,a,b,c,d,e";
        Long height = Long.valueOf(100000); //테스트를 위해 높은 height로 지정


        //when
        Ladder ladderObject = new Ladder(nameAry, height); //사다리 구성



        //then
        List<Line> lineStatus = ladderObject.getLineStatus();
        for(int i = 0 ; i < height ; i++){
            for(int j = 0 ; j < lineStatus.get(i).value.size() - 1 ; j++){
                assertTrue(lineStatus.get(i).value.get(j) + 1 != lineStatus.get(i).value.get(j+1)); //연속된 사다리가 제거된지 체크.
            }
        }

    }

    @Test
    void 콤마를_기준으로_참여자수를_나눈다() {
        //given
        String nameAry = "a,ab,abc,abcd"; //공백발생 예외
        Long height = Long.valueOf(10);

        //when
        Ladder ladderObject = new Ladder(nameAry, height);


        //then
        assertTrue(ladderObject.getPeopleCount() == 4);
    }

    @Test
    void 높이가_0_미만이면_예외가_발생한다() {
        //given
        String nameAry = "a,ab,abc,abcd";
        Long height = Long.valueOf(0); //높이가 0인 예외사항


        //when
        //객체생성시


        //then
        assertThatThrownBy(() -> {
                Ladder ladderObject = new Ladder(nameAry, height);
        }).isInstanceOf(Exception.class).hasMessageContaining("HeightBelowZero");
    }
}
