import java.util.ArrayList;
import java.util.Random;

public class LadderGame {
    private static final int MAX_NAME_LENGTH = 5;
    private final int countOfPerson;
    private final int heightOfLadder;
    private final String[] names;
    private final ArrayList<Line> bridges = new ArrayList<>();

    private class Line {
        final ArrayList<Boolean> points = new ArrayList<>();

        Line() {
            // 사다리가 겹치지 않도록 라인 초기화 로직
            Random rd = new Random();
            points.add(rd.nextBoolean());
            for(int i = 1; i < countOfPerson - 1; i ++) {
                points.add(!points.get(i - 1) && rd.nextBoolean());
            }
        }

        void printPoint(int idx) {
            char pointChar = points.get(idx) ? '-' : ' ';
            for(int i = 0; i < MAX_NAME_LENGTH; i ++) {
                System.out.print(pointChar);
            }
        }

        void printLine() {
            System.out.print('|');
            for(int i = 0; i < countOfPerson - 1; i ++) {
                printPoint(i);
                System.out.print('|');
            }
        }
    }

    public LadderGame(String[] names, int heightOfLadder) {
        this.names = names;
        this.countOfPerson = names.length;
        this.heightOfLadder = heightOfLadder;
        makeBridge();
    }

    public void printLadder() {
        printNames();
        for(int i = 0; i < heightOfLadder; i ++) {
            Line line = bridges.get(i);
            line.printLine();
            System.out.println();
        }
    }

    private void makeBridge() {
        for(int i = 0; i < heightOfLadder; i ++) {
            bridges.add(new Line());
        }
    }

    private void printNames() {
        for(int i = 0; i < countOfPerson; i ++) {
            System.out.printf("%"+"-"+MAX_NAME_LENGTH+"s ", names[i]);
        }
        System.out.println();
    }

}
