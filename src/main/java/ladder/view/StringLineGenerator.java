package ladder.view;

import java.util.ArrayList;
import java.util.List;

public class StringLineGenerator {
    // 상수
    private static final String COLUMN = "|";
    private static final String CONNECTED = "-";
    private static final String NOT_CONNECTED = " ";

    // 인스턴스 변수
    private final int charLimit;

    // 생성자
    public StringLineGenerator (int charLimit) {
        this.charLimit = charLimit;
    }

    // 메서드
    public String createRowString(List<Boolean> points) {
        List<String> result = new ArrayList<>();
        result.add(" ".repeat(charLimit / 2));
        String connRepeat = CONNECTED.repeat(charLimit);
        String notConnRepeat = NOT_CONNECTED.repeat(charLimit);

        for (Boolean isConnected : points) {
            result.add(COLUMN);
            result.add(isConnected ? connRepeat : notConnRepeat);
        }
        result.add(COLUMN);

        return String.join("", result);
    }
}
