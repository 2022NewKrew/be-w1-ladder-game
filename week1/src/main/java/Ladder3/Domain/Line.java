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
        boolean prevStep = false;
        for (int i=0; i < countOfPerson - 1; i++) {
            // 두개의 브릿지가 연속하여 그려지는 것을 방지
            Random rd = new Random();
            prevStep = rd.nextBoolean() & !prevStep;
            steps.add(prevStep);
        }
    }

    @Override
    public String toString() {
        return steps.stream()
            .map(step -> step ? BRIDGE.repeat(bridgeSize) : BLANK.repeat(bridgeSize))
            .collect(Collectors.joining(COLUMN, "  " + COLUMN, COLUMN));
    }
}
