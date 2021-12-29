import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<Line> lines;

    public Ladder(int width, int height) {
        setLines(width, height);
    }

    /**
     * 사다리 Line 상태를 세팅한다.
     */
    private void setLines(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.createRandomLine(width));
        }
        this.lines = lines;
    }

    /**
     * 사다리 상태를 문자열로 반환한다.
     */
    public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining());
    }

}
