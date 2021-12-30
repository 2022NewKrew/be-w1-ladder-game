package main.domain;
import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.Random;

public class LadderGame {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String empty = StringUtils.repeat(" ", MAX_NAME_LENGTH);
    private static final String bar = StringUtils.repeat("-", MAX_NAME_LENGTH);
    private static final Random rd = new Random();
    private final int heightOfLadder;
    private final String[] names;
    private final ArrayList<Line> bridges;

    public LadderGame(String[] names, int heightOfLadder) {
        bridges = new ArrayList<>();
        this.names = names;
        this.heightOfLadder = heightOfLadder;
        makeBridge();
    }

    public void printLadder() {
        printAllNames();
        for(Line bridge : bridges) {
            bridge.printLine();
            System.out.println();
        }
    }

    public ArrayList<Line> getBridges() {
        return bridges;
    }

    private void makeBridge() {
        for(int i = 0; i < heightOfLadder; i ++) {
            bridges.add(new Line());
        }
    }

    private static void printName(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            name = StringUtils.truncate(name, MAX_NAME_LENGTH);
        }
        System.out.printf("%" + "-" + MAX_NAME_LENGTH + "s ", name);
    }

    private void printAllNames() {
        for (String name : names) {
            printName(name);
        }
        System.out.println();
    }

    private static String pointToString(boolean point) {
        return point ? bar : empty;
    }

    public class Line {
        final ArrayList<Boolean> points;

        private Line() {
            points = new ArrayList<>();
            if(names.length <= 1) return;

            // 사다리가 겹치지 않도록 라인 초기화 로직
            points.add(rd.nextBoolean());
            for(int i = 1; i < names.length - 1; i ++) {
                points.add(!points.get(i - 1) && rd.nextBoolean());
            }
        }

        private void printLine() {
            System.out.print('|');
            for(boolean point : points) {
                System.out.print(pointToString(point));
                System.out.print('|');
            }
        }

        public ArrayList<Boolean> getPoints() {
            return points;
        }
    }

}
