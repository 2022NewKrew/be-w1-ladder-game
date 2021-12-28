import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    @Test
    public void 테스트3x5() {
        String str = "3\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트5x3() {
        String str = "5\n3";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트1x3() {
        String str = "1\n3";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트5x1() {
        String str = "5\n1";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트10x10() {
        String str = "10\n10";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트100x100() {
        String str = "100\n100";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

}