import laddergame.domain.Line;
import laddergame.domain.Point;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

class LineTest {
    //가로 계단 중복시, 빈칸으로 들어가는지 테스트
    @Test
    void preventDoubleStair() {
        Line line = new Line(0);
        line.addPoint(new Point(true));
        line.addPoint(new Point(true));
        System.out.println(line.toString());
        assertThat(line.toString()).isEqualTo("  |-----|     |");
    }

    //사다리 내에서 계단이 있는 쪽으로 잘 가는지, 없다면 방향전환을 안하는지 테스트
    //findAvailableDirection return -1(왼쪽) or 0(이동없음) or 1(오른쪽방향)
    @Test
    void findAvailableDirection(){
        Line line = new Line(0);
        line.addPoint(new Point(true));
        line.addPoint(new Point(false)); //(|-----|     |)
        int direction = line.findAvailableDirection(1);//(|(0)-----|(1V)     |(2))
        System.out.println(direction);
        assertThat(direction).isEqualTo(-1);

        line = new Line(0);
        line.addPoint(new Point(false));
        line.addPoint(new Point(true)); //(|     |-----|)
        direction = line.findAvailableDirection(1);//(|(0)     |(1V)-----|(2))
        System.out.println(direction);
        assertThat(direction).isEqualTo(1);

        line = new Line(0);
        line.addPoint(new Point(false));
        line.addPoint(new Point(false)); //(|     |     |)
        direction = line.findAvailableDirection(1);//(|(0)     |(1V)     |(2))
        System.out.println(direction);
        assertThat(direction).isEqualTo(0);
    }
}