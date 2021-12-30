package Ladder3.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Line {

    private static final String BRIDGE = "-";
    private static final String BLANK = " ";
    private static final String COLUMN = "|";

    private final int bridgeSize;
    private final List<Boolean> steps = new ArrayList();

    protected Line (int countOfPerson, int bridgeSize) {
        this.bridgeSize = bridgeSize;
        initLine(countOfPerson);
    }

    private void initLine(int countOfPerson) {
        boolean prevStep = false;

        for (int i=0; i < countOfPerson - 1; i++) {
            // 두개의 브릿지가 연속하여 그려지는 것을 방지
            prevStep = determineToCreateBridge(prevStep);
            steps.add(prevStep);
        }
    }

    private boolean determineToCreateBridge(boolean prevStep) {
        Random rd = new Random();
        return rd.nextBoolean() & !prevStep;
    }

    @Override
    public String toString() {
        return steps.stream()
            .map(step -> step ? BRIDGE.repeat(bridgeSize) : BLANK.repeat(bridgeSize))
            .collect(Collectors.joining(COLUMN, "  " + COLUMN, COLUMN));
    }

    private boolean testLine() {
        boolean prevStep = false;
        for (boolean curStep: steps) {
            if (prevStep & curStep) {
                return false;
            }
            prevStep = curStep;
        }
        return true;
    }

    public void main(String[] args) {
        System.out.println("Line 에 선이 연달아 나오지 않는가? => " + testLine());
    }
}
