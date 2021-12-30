package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String EMPTY_SPACE = " ";
    private static final Random RANDOM = new Random();

    private final List<Boolean> connected; // point 간 연결 여부

    Line(List<Boolean> connected) {
        this.connected = connected;
    }

    /**
     * 랜덤으로 Line 객체를 생성한다.
     */
    static Line createRandomLine(int size) {
        List<Boolean> connected = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            addRandomBooleanIfPrevNotConnected(connected);
        }
        return new Line(connected);
    }

    /**
     * 이전의 가로라인이 연결되어 있는 경우 false, 연결되어 있지 않은 경우 랜덤으로 연결 여부를 세팅한다.
     */
    private static void addRandomBooleanIfPrevNotConnected(List<Boolean> connected) {
        if (connected.isEmpty()) {
            connected.add(RANDOM.nextBoolean());
            return;
        }

        connected.add(!connected.get(connected.size() - 1) && RANDOM.nextBoolean());
    }

    /**
     * 사다리 cell 의 값이 true 라면 '-', false 라면 ' '(공백)을 반환한다.
     */
    private String parseConnectedHorizontal(boolean connected) {
        int count = Participant.MAX_LENGTH_OF_PARTICIPANT_NAME;
        return connected ? HORIZONTAL.repeat(count) : EMPTY_SPACE.repeat(count);
    }

    /**
     * 사다리 Line 을 문자열로 변환하여 반환한다.
     */
    public String toString() {
        StringBuilder line = new StringBuilder();
        line.append(EMPTY_SPACE.repeat(Participant.MAX_LENGTH_OF_PARTICIPANT_NAME / 2))
                .append(VERTICAL)
                .append(connected.stream()
                        .map(this::parseConnectedHorizontal)
                        .collect(Collectors.joining(VERTICAL)))
                .append(VERTICAL);
       return line.toString();
    }

}
