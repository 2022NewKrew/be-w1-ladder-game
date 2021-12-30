import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.ladder.LadderWithNameGenerator;
import domain.ladder.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.input.config.LadderConfigWithName;
import view.output.LadderPrinter;
import view.output.LadderPrinterWithName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.*;
import java.util.Arrays;
import java.util.List;

class LadderGameWithNameTest {

    private static LadderGenerator ladderGenerator = new LadderWithNameGenerator();
    private static LadderPrinter ladderPrinter = new LadderPrinterWithName();

    @Test
    @DisplayName("기본 사이즈의 사다리가 생성되는지 테스트")
    public void 테스트3x5(){
        String str = "a,bb,jef\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.main(null);
    }

    @Test
    @DisplayName("한 명일 경우 사다리가 정상적으로 생성되는지 테스트")
    public void 테스트1x5(){
        String str = "bbb\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        LadderGame ladderGame = new LadderGame();
        ladderGame.main(null);
    }

    @Test
    @DisplayName("사람 이름 입력이 없을 경우 실패하는지 테스트")
    public void 실패테스트0x5(){
        String str = "\n5";

        try (InputStream bis = new ByteArrayInputStream(str.getBytes())) {
            System.setIn(bis);
        } catch (Exception e){
            e.printStackTrace();
        }

        assertThrows(IllegalArgumentException.class, () -> LadderGame.main(null));
    }

    @Test
    @DisplayName("Line 객체에 다리가 그려지는지 테스트: List 사이즈 확인")
    public void Line객체생성_테스트(){
        // given
        int peopleCount = 3;
        int height = 5;
        List<String> names = Arrays.asList("jeff", "andy", "raons");
        Ladder ladder = ladderGenerator.createLadder(new LadderConfigWithName(peopleCount, height, names));
        int width = (peopleCount-1)*2 + 1;

        // when
        List<Line> ladderShape = ladder.getLadderShape();
        int ladderShapeSize =  ladderShape.size();
        Line line = ladderShape.get(0);
        int lineSize = line.getPoints().size();

        // then
        assertThat(ladderShapeSize).isEqualTo(5);
        assertThat(lineSize).isEqualTo(width);

    }

    @Test
    @DisplayName("최대 5 글자를 정확히 출력하는지 처리하는 로직에 대한 테스트")
    public void 이름출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // given
        int peopleCount = 5;
        int height = 5;
        List<String> names = Arrays.asList("a", "bb", "jef", "andy", "raons");
        Ladder ladder = ladderGenerator.createLadder(new LadderConfigWithName(peopleCount, height, names));

        // when
        ladderPrinter.printLadderShape(ladder);

        // then
        List<String> output = Arrays.asList(out.toString().split("\n"));
        assertThat(output.get(1)).isEqualTo("  a    bb    jef  andy  raons ");

    }
}
