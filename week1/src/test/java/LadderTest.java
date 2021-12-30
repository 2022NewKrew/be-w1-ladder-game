import Ladder3.Domain.Drawer;
import Ladder3.Domain.Line;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderTest {

    private static final int BRIDGE_SIZE = 5;
    private Drawer drawer;

    @BeforeEach
    void setUp() {
        drawer = new Drawer(new ArrayList<Line>(), new String[0], BRIDGE_SIZE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void nameLength() {
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("a").length());
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("aA").length());
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("aA1").length());
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("aA1_").length());
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("aA1_?").length());
        assertEquals(BRIDGE_SIZE, drawer.getNameTag("aA1_?/").length());
    }
}
