import domain.CrossLine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrossLineTest {
    int size = 5;

    @Test
    void 객체생성테스트() {
        CrossLine crossLine = new CrossLine(size);

        Assertions.assertEquals(crossLine.getBars().size(), size);
    }

    @Test
    void 랜덤바생성바로그전께설치되었을때() {
        CrossLine crossLine = new CrossLine(size);
        crossLine.getBars().set(0, true);

        Assertions.assertEquals(crossLine.generateRandomBar(1), false);
        //공부를해야겟어여...
    }
}