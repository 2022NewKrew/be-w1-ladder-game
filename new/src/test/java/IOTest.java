
import ladder.domain.Ladder;
import ladder.domain.LadderConfig;
import ladder.view.IO;
import org.junit.jupiter.api.*;


import static org.assertj.core.api.Assertions.*;

class IOTest {
    static IO io;
    static Ladder ladder;
    static LadderConfig ladderConfig;
    static final int maxNameLength = 5;

    @BeforeEach
    public void setup() {
        io = new IO();
        String[] peopleTest1 = {"adfeaf","s","ekrkewl","ss","r"};
        ladderConfig = new LadderConfig(5,5, peopleTest1);
        ladder = new Ladder(ladderConfig);
    }

    @Test
    public void printHeaderLengthTest() {
        String printedHeader = io.printHeader(ladder, maxNameLength);
        String after = printedHeader.trim().replaceAll(" +", " ");
        String[] strArr = after.split("\\s");

        assertThat(strArr).as("Name Length Error").allSatisfy(elem -> assertThat(elem.length()).isLessThan(6));


    }

    @AfterEach
    public void teardown() {
        System.out.println("Done Name Length check test !");
    }
}

