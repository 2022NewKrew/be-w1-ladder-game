package ladderStage3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line;
    private static final Random random = new Random();

    private static final String LINE = "-----";
    private static final String LADDER = "|";
    private static final String BLANK = "     ";

    public Line(int participantCount) {
        this.line = this.create(participantCount);
    }

    public List<Boolean> create(int participantCount) {
        List<Boolean> line = new ArrayList<>();
        for (int count = 0; count < participantCount - 1; count++) {
            line.add(createNonOverlap(line));
        }
        return line;
    }

    // 사다리 왼쪽과 이미 연결되어 있다면 false를 입력, 연결되어 있지 않거나 처음 상태라면 랜덤값을 입력하는 메소드
    private boolean createNonOverlap(List<Boolean> line) {
        boolean nextStatus = random.nextBoolean();
        if(line.isEmpty()) {
            return nextStatus;
        }

        if(isConnected(line, nextStatus)) {
            return false;
        }

        return nextStatus;
    }

    // 사다리 라인이 겹치면 안되기 때문에, 왼쪽에 이미 연결이 되어있는지 확인하는 메소드
    private boolean isConnected(List<Boolean> line, boolean nextStatus) {
        return line.get(line.size() - 1) && nextStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(boolean b : line) {
            sb.append(LADDER);
            sb.append(b ? LINE : BLANK);
        }
        sb.append(LADDER);
        return sb.toString();
    }
}
