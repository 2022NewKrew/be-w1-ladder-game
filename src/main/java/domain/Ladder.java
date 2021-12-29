package domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }
}