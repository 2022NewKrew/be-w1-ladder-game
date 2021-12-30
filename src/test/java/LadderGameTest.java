import application.RandomBooleanGenerator;
import application.RowGeneratorFactory;
import domain.Ladder;
import domain.Row;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.LadderPrinter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int NUMBER_OF_BRIDGES = 7;
    private static final int HEIGHT_LADDER = 7;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("연속으로 True를 반환하지 않는가")
    void 연속으로_True_반환안함() {
        RandomBooleanGenerator generator = new RandomBooleanGenerator();
        boolean fistBoolean = generator.getRandomBoolean();
        boolean secondBoolean = generator.getRandomBoolean();

        assertThat(fistBoolean & secondBoolean)
                .isFalse();
    }

    @Test
    @DisplayName("행, 열의 개수만큼 생성되었는가")
    void 사다리_생성() {
        List<Row> rows = RowGeneratorFactory.getLadderRows(NUMBER_OF_BRIDGES, HEIGHT_LADDER);

        assertThat(rows.size())
                .isEqualTo(HEIGHT_LADDER);
        for (Row row : rows) {
            assertThat(row.getBridges().size())
                    .isEqualTo(NUMBER_OF_BRIDGES);
        }
    }

    @DisplayName("출력 길이가 올바른가")
    @Test
    void 출력_검증() {
        List<String> nameList = List.of("binar", "clo", "hoodi", "champ", "sun", "root", "vince", "trevi");
        Ladder ladder = new Ladder(RowGeneratorFactory.getLadderRows(NUMBER_OF_BRIDGES, HEIGHT_LADDER));

        LadderPrinter.drawLadder(nameList, ladder);
        String[] strings = outputStreamCaptor.toString().split("\n");

        assertThat(strings[1].length())
                .isEqualTo((MAXIMUM_NAME_LENGTH + 1) * (NUMBER_OF_BRIDGES + 1) - 1);
    }
}