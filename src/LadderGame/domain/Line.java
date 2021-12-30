package LadderGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    // 클래스 변수 및 상수
    private static final String BAR = "ㅣ";
    private static final String EMPTY = "     ";
    private static final String BRIDGE = "-----";
    private static final Random random = new Random();

    // 인스턴스 변수
    private final List<String> points;
    private final List<Boolean> isEmptyElement;

    Line(int row) throws Exception {
        isEmptyElement = new ArrayList<>();
        checkRowValid(row);
        points = IntStream.range(0, row).mapToObj(this::getLadderElement).collect(Collectors.toList());
    }

    private void checkRowValid(int row) throws Exception {
        if(row <= 0){
            throw new Exception("사다리의 높이는 0보다 커야합니다.");
        }
    }

    private String getLadderElement(int rowNumber) {
        isEmptyElement.add(true);
        if (rowNumber % 2 == 0) {
            return BAR;
        }

        boolean isLadderBridge = getRandomBridgeByPercent(60);
        if (noBridgeOnBothSide(rowNumber) && isLadderBridge) {
            isEmptyElement.set(rowNumber, false);
            return BRIDGE;
        }
        return EMPTY;
    }

    private boolean noBridgeOnBothSide(int rowNumber) {
        final int FIRST_BRIDGE = 1;
        final int GAP = 2;

        if (rowNumber == FIRST_BRIDGE) {
            return true;
        }
        return isEmptyElement.get(rowNumber - GAP);
    }

    private boolean getRandomBridgeByPercent(int percent) {
        return random.nextInt(100) >= percent;
    }

    public List<String> getPoints() {
        return points;
    }
}
