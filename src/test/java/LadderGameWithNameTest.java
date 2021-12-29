import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LadderGameWithNameTest {

    @Test
    public void 테스트3x5(){
        String str = "aa,bbb,cccc\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 테스트1x5(){
        String str = "bbb\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame.main(null);
    }

    @Test
    public void 실패테스트0x5(){
        String str = "\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        assertThrows(IllegalArgumentException.class, () -> LadderGame.main(null));
    }
}
