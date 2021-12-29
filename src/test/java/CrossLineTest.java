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
    void 유효한로케이션테스트() {
        //공부를해야겟어여...
    }
}