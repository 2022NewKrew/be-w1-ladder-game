import ladder.domain.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    static Line horizonLine;

    @BeforeAll
    public static void initialize() {
        horizonLine = new Line();
    }

    /*
   previousLine = false 이전 열의 사다리가 이어져있지 않은 경우
   isLink = false 이번 열의 사다리를 긋는다고 판단하는 경우
    */
    @Test
    @DisplayName("이전 사다리 X, 현재 사다리 O")
    public void makeVerticalLineSuccessTest() {
        //given
        boolean previousLink = false;
        boolean curLink = true;
        //when
        boolean isLink = horizonLine.checkAbleLink(previousLink, curLink);
        //then
        Assertions.assertEquals(isLink, true);
    }


    /*
    previousLine = false 이전 열의 사다리가 이어져있지 않은 경우
    isLink = false 이번 열의 사다리를 긋지않는다고 판단하는 경우
     */
    @Test
    @DisplayName("이전 사다리 X, 현재 사다리 X")
    public void makeVerticalLineFailTest() {
        //given
        boolean previousLink = false;
        boolean curLink = false;

        //when
        boolean isLink = horizonLine.checkAbleLink(previousLink, curLink);

        //then
        Assertions.assertEquals(isLink, false);
    }

    /*
    previousLine = true 이전 열의 사다리가 이어져있는 경우
    isLink = false 이번 열의 사다리를 긋지않는다고 판단하는 경우
     */
    @Test
    @DisplayName("이전 사다리 O, 현재 사다리 X")
    public void makeVerticalLineFailTest2() {
        //given
        boolean previousLink = true;
        boolean curLink = false;

        //when
        boolean isLink = horizonLine.checkAbleLink(previousLink, curLink);

        //then
        Assertions.assertEquals(isLink, false);
    }

    /*
    previousLine = true 이전 열의 사다리가 이어져있는 경우
    isLink = true 이번 열의 사다리를 긋는다고 판단하는 경우
     */
    @Test
    @DisplayName("이전 사다리 O, 현재 사다리 O")
    public void makeVerticalLineFailTest3() {
        boolean previousLink = true;
        boolean curLink = true;

        boolean isLink = horizonLine.checkAbleLink(previousLink, curLink);

        Assertions.assertEquals(isLink, false);
    }
}
