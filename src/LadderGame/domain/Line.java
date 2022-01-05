package LadderGame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Line {

    // 클래스 변수 및 상수
    private static final String BAR = "|";
    private static final String EMPTY = "     ";
    private static final String BRIDGE = "-----";
    private static final Random random = new Random();

    // 인스턴스 변수
    private final List<String> points;
    private final List<Boolean> isEmptyElement;

    public Line(int row) {
        isEmptyElement = new ArrayList<>();
        points = IntStream.range(0, row).mapToObj(this::getLadderElement).collect(Collectors.toList());
    }

    protected String getLadderElement(int rowNumber) {
        isEmptyElement.add(true);
        if (rowNumber % 2 == 0) {
            return BAR;
        }

        boolean isLadderBridge = getRandomBridgeByPercent(40);
        if (noBridgeOnLeftSide(rowNumber) && isLadderBridge) {
            isEmptyElement.set(rowNumber, false);
            return BRIDGE;
        }
        return EMPTY;
    }

    protected boolean noBridgeOnLeftSide(int rowNumber) {
        final int FIRST_BRIDGE = 1;
        final int GAP = 2;

        if (rowNumber == FIRST_BRIDGE) {
            return true;
        }
        return isEmptyElement.get(rowNumber - GAP);
    }

    private boolean getRandomBridgeByPercent(int percent) {
        return random.nextInt(100) <= percent;
    }

    public List<String> getPoints() {
        return points;
    }

    public boolean isBRIDGE(int idx){
        return points.get(idx).compareTo(BRIDGE) >= 0;
    }
}
