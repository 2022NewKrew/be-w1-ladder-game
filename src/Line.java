import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {
    private static final char VERTICAL_LINE = '|';
    private static final char HORIZONTAL_LINE = '-';
    private static final char EMPTY_LINE = ' ';
    private static final Random random = new Random();
    private List<Character> points;

    public Line(int width) {
        createLine(width);
    }

    private void createLine(int width){
        points = new ArrayList<>();
        points = IntStream.range(0, width)
                .mapToObj(this::getPointChar)
                .collect(Collectors.toList());
    }

    private char getPointChar(int index){
        if(index%2==0) return VERTICAL_LINE;
        if(random.nextBoolean()) return HORIZONTAL_LINE;
        return EMPTY_LINE;
    }

    public List<Character> getPoints() {
        return points;
    }
}
