package ladder.dto;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Line;

public class LineDto {

    private final List<Boolean> points;

    public LineDto(List<Boolean> points) {
        this.points = points;
    }

    public static LineDto lineToDto(Line line) {
        return new LineDto(new ArrayList<>(line.getPoints()));
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
