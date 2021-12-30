import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class Util {
    @Test
    void formatStringSizeTest(){
        Util.formatStringSize("kennypark", 5);
    }
}
