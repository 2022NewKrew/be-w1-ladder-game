import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;

class MainTest {
    @Test
    public void 정상실행10x10(){
        String str = "10\n10";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        Main.main(null);
    }

    @Test
    public void 정상실행30x30(){
        String str = "30\n30";

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        Main.main(null);
    }

    @Test
    public void 잘못된_width(){
        String str = "0\n10";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.main(null));
    }

    @Test
    public void 잘못된_height(){
        String str = "10\n0";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        System.setIn(byteArrayInputStream);
        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.main(null));
    }
}