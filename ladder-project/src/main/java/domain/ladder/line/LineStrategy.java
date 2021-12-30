package domain.ladder.line;

import java.util.List;

public interface LineStrategy {

    List<Boolean> createLine(int column);
}
