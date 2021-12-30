package ladder.view;

import java.util.ArrayList;
import java.util.List;

public class StringLineGenerator {
    // 생성자
    public StringLineGenerator () {}

    // 메서드
    public String createRowString(List<Boolean> points,
                                        String column, String conn, String notConn, int participant) {
        List<String> result = new ArrayList<>();
        result.add(" ".repeat(participant / 2));
        for (Boolean isConnected : points) {
            result.add(column);
            result.add(isConnected ? conn.repeat(participant) : notConn.repeat(participant));
        }
        result.add(column);

        return String.join("", result);
    }
}
